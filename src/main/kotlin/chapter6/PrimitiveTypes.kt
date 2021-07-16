package chapter6

fun main() {
    val num: Int = 5 // Kotlin doesn't distinguish between primitive and wrapper types in code. This is compiled to a primitive type
    val numbers: List<Int> = listOf(1, 1, 2, 3, 5) // The List<Int> is compiled to the Java Integer class.

    // val longNum: Long = num  doesn't compile because Kotlin doesn't explicitly convert primitive types
    val longNum: Long = num.toLong() // This explicitly converts the Int to Long
    val longs = listOf(1L, 1L, 2L, 3L, 5L)
    // println(num in longs) doesn't compile because Kotlin doesn't convert the types
    println(num.toLong() in longs) // Compiles and prints true
    val numlong: Long = 10L
    println(num + numlong) // This WILL work because the arithmetic operators are overloaded for multiple types

    val numAny: Any = 6 // Any is Kotlin's version of Java's Object

    printSomething()
}

fun printSomething(): Unit { // Unit is like void in Java, except it is a type. It can be omitted as a return type for functions
    println("Something")
}

// The nothing type indicates that the function doesn't return normally. This is different from Unit because that will terminate and return a Unit
fun fail(message: String): Nothing = throw Exception(message)