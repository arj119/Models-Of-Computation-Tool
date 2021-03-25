package rmcode

import java.lang.StringBuilder

data class LabelInstruction(val label: Label, val instr: Instruction) {
    override fun toString(): String {
        return "$label: $instr\n"
    }
}

data class Label(val num: Int) {
    override fun toString(): String {
        return "L$num"
    }
}

data class Register(val num: Int) {
    override fun toString(): String {
        return "R$num"
    }
}

interface Instruction {
    fun encode(): Encoding;
}

class Halt() : Instruction {
    override fun toString(): String {
        return "HALT"
    }

    override fun encode(): Encoding {
        return NumberEncoding(0)
    }

    override fun equals(other: Any?): Boolean {
        return other is Halt
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}

data class IncInstruction(val regToInc: Register, val nextInstr: Label) : Instruction {
    override fun toString(): String {
        return "$regToInc+ -> $nextInstr"
    }

    override fun encode(): Encoding {
        return EvenEncoding(regToInc.num * 2, NumberEncoding(nextInstr.num))
    }
}

data class DecInstruction(val regToDec: Register, val ifNotZeroJump: Label, val ifZeroJump: Label) : Instruction {
    override fun toString(): String {
        return "$regToDec+ -> $ifNotZeroJump, $ifZeroJump"
    }

    override fun encode(): Encoding {
        return EvenEncoding(regToDec.num * 2 + 1, OddEncoding(ifNotZeroJump.num, NumberEncoding(ifZeroJump.num)))
    }
}

data class Configuration(val nextInstr: Int, val registers: IntArray) {
    override fun toString(): String {
        val builder = StringBuilder("($nextInstr")
        registers.forEach {
            builder.append(", $it")
        }
        builder.append(")")
        return builder.toString()
    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(javaClass != other?.javaClass) return false

        other as Configuration

        if(nextInstr != other.nextInstr) return false
        if(!registers.contentEquals(other.registers)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nextInstr
        result = 31 * result + registers.contentHashCode()
        return result
    }
}