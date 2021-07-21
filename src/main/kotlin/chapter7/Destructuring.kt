package chapter7

fun main() {
    val something = ThreeThings(5, "test", 6.5)
    val (n, s, d) = something // Since the component methods are defined, it can be destructed into three parts
    println("n is $n, s is $s, and d is $d")

    val somethingElse = ThreeOtherThings(false, 5, 3F)
    println(somethingElse)
    val (b, y, f) = somethingElse // Since it is a data class, the component methods are already defined by the compiler
    println("b is $b, y is $y, and f is $f")

    val someMap = mapOf(
        "orange" to "blue",
        "yellow" to "purple",
        "red" to "green"
    )
    for ((key, value) in someMap) { // someMap iterator is able to be destructed
        println("key: $key; value: $value")
    }
}

class ThreeThings(val thing1: Int, val thing2: String, val thing3: Double) {
    // Operator functions "componentN" for destructing a class to values
    operator fun component1() = thing1
    operator fun component2() = thing2
    operator fun component3() = thing3
}

data class ThreeOtherThings(val thingA: Boolean, val ThingB: Byte, val ThingC: Float)