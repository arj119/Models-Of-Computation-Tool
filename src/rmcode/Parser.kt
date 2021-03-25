package rmcode

import antlr.BasicParser.*
import antlr.BasicParserBaseVisitor
import java.lang.Integer.parseInt
import java.lang.UnsupportedOperationException

class Parser : BasicParserBaseVisitor<ArrayList<LabelInstruction>>() {

    fun visitProgram(ctx: ProgContext?): Map<Int, LabelInstruction> {
        val instructions = ArrayList<LabelInstruction>()
        ctx?.instr()?.forEach {
            instructions.addAll(
                    visitInstr(it)
            )
        }

        val lastLabel = instructions.last().label.num

        val out = Array<LabelInstruction>(lastLabel + 1) {
            i -> LabelInstruction(Label(i), Halt())
        }

        return instructions.map {it.label.num to it }.toMap()
    }



    fun visitInstr(ctx: InstrContext): ArrayList<LabelInstruction> = when(ctx) {
        is PlusInstrContext -> arrayListOf(visitPlus(ctx))
        is MinusInstrContext -> arrayListOf(visitMinus(ctx))
        is HaltInstrContext -> arrayListOf(visitHalt(ctx))
        is SeqInstrContext -> {
            val instr = visitInstr(ctx.fst)
            instr.addAll(visitInstr(ctx.snd))
            instr
        }
        else -> throw UnsupportedOperationException()
    }

    fun visitPlus(ctx: PlusInstrContext): LabelInstruction {
        val label = visitLabels(ctx.id)
        val instr = IncInstruction(visitReg(ctx.reg), visitLabels(ctx.next))
        return LabelInstruction(label, instr)
    }

    fun visitReg(ctx: RegisterContext): Register {
        return Register(parseInt(ctx.registerNum.text))
    }

    fun visitLabels(ctx: LabelContext): Label {
        return Label(parseInt(ctx.labelNum.text))
    }

    fun visitMinus(ctx: MinusInstrContext): LabelInstruction {
        val label = visitLabels(ctx.id)
        val instr = DecInstruction(visitReg(ctx.reg), visitLabels(ctx.ifNotZJump), visitLabels(ctx.ifZeroJump))
        return LabelInstruction(label, instr)
    }

    fun visitHalt(ctx: HaltInstrContext): LabelInstruction {
        return LabelInstruction(visitLabels(ctx.id), Halt())
    }

}