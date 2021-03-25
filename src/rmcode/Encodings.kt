package rmcode

import kotlin.math.pow
import kotlin.math.roundToInt

interface Encoding {
    fun getValue(): Int
}

data class NumberEncoding(val num: Int): Encoding {
    override fun getValue(): Int {
        return num;
    }

    override fun toString(): String {
        return "$num"
    }
}

data class EvenEncoding(val x: Int, val y: Encoding): Encoding {
    override fun toString(): String {
        return "<<$x, $y>>"
    }

    override fun getValue(): Int {
        return 2.0.pow(x).roundToInt() * (2*y.getValue() + 1)
    }
}

data class OddEncoding(val x: Int, val y: Encoding): Encoding {
    override fun toString(): String {
        return "<$x, $y>"
    }

    override fun getValue(): Int {
        return 2.0.pow(x).roundToInt() * (2*y.getValue() + 1) - 1
    }
}