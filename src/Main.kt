import antlr.BasicLexer
import antlr.BasicParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import rmcode.*
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt
import java.lang.Math.pow
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.system.exitProcess

enum class ExitCode(val code: Int) {
    EXIT_SUCCESS(0),
    SYNTAX_FAILURE(100),
    SEMANTIC_FAILURE(200),
    RUNTIME_ERROR(255),
    PATH_ERROR(101)
}

object Main {

    var program: Map<Int, LabelInstruction> = emptyMap()

    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        try {
            while(true) {
                print(">>> ")
                val line = scanner.nextLine()
                processCommand(line)

            }
        } catch(e: IllegalStateException) { // System.in has been closed
            println("System.in was closed; exiting")
        } catch(e: NoSuchElementException) {
            println("System.in was closed; exiting")
        }
    }

    fun processCommand(command: String) {
        val tokens = command.split(" ")
        when(tokens[0]) {
            "load" -> {
                println("loading ${tokens[1]}: \n")
                printInstr(parse(tokens[1]).values)
                println("\n...loaded")
            }
            "run" -> {
                val config = tokens[1].removeSurrounding("(",")").split(",").map { parseInt(it) }
                runProgram(Configuration(config[0], config.subList(1, config.size).toIntArray()))

            }
            "encode" -> {
                val list = encode()
                println("Has list representation: $list")
                println("Has godel number: ${encodedList(list).getValue()}")
            }
            "exit" -> exitProcess(0)
            "decode" -> {
                val listEncoded = decodeToList(parseDecodeToken(tokens[1]))
                println(listEncoded)
                val instructionCodeList = encodingToList(listEncoded)
                println("This results in list: $instructionCodeList")
                val prog = decodeListToProgram(instructionCodeList)
                println()
                printInstr(prog)
            }
            "body" -> {
                decodeToInstruction(parseInt(tokens[1]))
            }
            else -> println("Command ${tokens[0]} not supported")
        }
    }

    fun parseDecodeToken(token: String): Int {
        return if(token.contains("*")) {
            val multTok = token.split('*')
            val fst = parsePower(multTok[0])
            val snd = parsePower(multTok[1])
            fst * snd
        } else {
            parseInt(token)
        }
    }

    fun parsePower(token: String): Int {
        return if(token.contains('^')) {
            val power = token.split('^')
            val fst = parseDouble(power[0])
            val snd = parseDouble(power[1])
            fst.pow(snd).roundToInt()
        } else {
            parseInt(token)
        }
    }

    fun parse(input: String): Map<Int, LabelInstruction> {
        val path = Paths.get(input)

        if(!Files.exists(path)) {
            println("File does not exist")
        }

        // Lexical analysis
        val charStream = CharStreams.fromPath(path)
        val lexer = BasicLexer(charStream)

        // Syntax analysis
        val tokens = CommonTokenStream(lexer)
        val parser = BasicParser(tokens)

        val rmmachine = parser.prog()

        val instructionBuilder = Parser()
        val instructions = instructionBuilder.visitProgram(rmmachine)
        this.program = instructions
        return instructions
    }

    fun printInstr(instr: Collection<LabelInstruction>) {
        instr.forEach {
            print(it)
        }
    }

    fun runProgram(config: Configuration) {
        println(config)
        if(program.containsKey(config.nextInstr)) {
            val instr = program[config.nextInstr]?.instr
            val registers = config.registers
            when (instr) {
                is IncInstruction -> {
                    registers[instr.regToInc.num]++
                    runProgram(Configuration(instr.nextInstr.num, registers))
                }

                is DecInstruction -> {
                    val regToDec = instr.regToDec.num
                    var nextinstr = instr.ifZeroJump.num
                    if(registers[regToDec] != 0) {
                        nextinstr = instr.ifNotZeroJump.num
                        registers[regToDec]--
                    }
                    runProgram(Configuration(nextinstr, registers))
                }
            }

        }

    }

    fun encodeAsList() {
        val list = program.values.map { it.instr.encode() }
        println(list)
        println(list.map{it.getValue()})
    }

    fun decodeToList(num: Int): Encoding {
        if(num == 0) {
            return NumberEncoding(0)
        }
        var evenEncoding = evenEncodeFromNum(num)
        val x = evenEncoding.x
        val y = evenEncoding.y.getValue()
        println("Number: $num " +
                "\nBinary: ${Integer.toBinaryString(num)}")
        println("Produces encoding <<$x, $y>>")
        println()
        return EvenEncoding(x, decodeToList(y))
    }

    fun evenEncodeFromNum(num: Int): EvenEncoding {
        var x = 0
        var numCopy = num
        while(numCopy % 2 == 0) {
            x++
            numCopy = numCopy shr 1
        }
        numCopy = numCopy shr 1
        val y = numCopy
        return EvenEncoding(x, NumberEncoding(y))
    }

    fun oddEncodeFromNum(num: Int): OddEncoding {
        var x = 0
        var numCopy = num
        while(numCopy % 2 != 0) {
            x++
            numCopy = numCopy shr 1
        }
        numCopy = numCopy shr 1
        val y = numCopy
        return OddEncoding(x, NumberEncoding(y))
    }

    fun encodingToList(encoding: Encoding): List<Int> {
        val list = ArrayList<Int>()
        var fst = encoding
        while(fst is EvenEncoding) {
            list.add(fst.x)
            fst = fst.y
        }
        return list
    }

    fun decodeListToProgram(list: List<Int>): List<LabelInstruction> {
        val instructions = list.mapIndexed { i: Int, x: Int ->
            LabelInstruction(Label(i), decodeToInstruction(x))
        }
        program = instructions.map {it.label.num to it}.toMap()
        return instructions
    }

    fun decodeToInstruction(num: Int): Instruction {
        println()
        println("Body of $num:")
        val instruction: Instruction = if (num == 0) {
            Halt()
        } else {
            val yz = evenEncodeFromNum(num)
            println("<<y,z>> = $yz")
            val y = yz.x
            val z = yz.y.getValue()
            val reg = Register(y)
            if(y % 2 == 0) {
                println("y is even")
                IncInstruction(reg, Label(z))
            } else {
                println("y is odd")
                val jk = oddEncodeFromNum(z)
                println("<j,k> = $jk")
                DecInstruction(reg, Label(jk.x), Label(jk.y.getValue()))
            }
        }
        println(instruction)
        return instruction
    }

    fun encode(): List<Int> {
        return program.values.map {
            println()
            println("Body of instruction: $it")
            val encoding = it.instr.encode()
            println("Encodes to: $encoding")
            val value = encoding.getValue()
            println("Which has value: $value")
            value
        }
    }

    fun encodedList(prog: List<Int>): Encoding {
        if(prog.size ==1) {
            return EvenEncoding(prog[0], NumberEncoding(0))
        }
        return EvenEncoding(prog[0], encodedList(prog.subList(1, prog.size)))
    }

}
