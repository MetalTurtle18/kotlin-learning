package chapter2

/**
 * This is the main function to run all of the code from in this file
 */
fun main(args: Array<String>) {
    // The most basic program--Hello world!
    println("Hello, world!")

    // Printing the result of a call to the "max" function. The expected output is 12
    println(max(10, 12))
    // We expect the same result: 12
    println(betterMax(10, 12))
    // Of course we expect the same result again: 12
    println(evenBetterMax(10, 12))

    // These variables do not need to specify a type--Kotlin does this on its own
    val name = "MetalTurtle" // A variable declared with "val" is like Java's "final"--it cannot be changed
    var number = 300 // A variable declared with "var" can be changed
    println(name) // Prints MetalTurtle
    println(number) // Prints 300
    number = 400 // Since number was declared with "var," it can be changed
    println(number) // Prints 400
    // If a variable is declared without an initializer, it needs to specific a return type
    val pi: Double
    pi = 3.1415
    println(pi) // Prints 3.1415

    // Kotlin has a feature called string templates. It allows easier formatting of strings instead of using + as you would in Java
    println("My name is $name.") // Prints "My name is MetalTurtle." The "$" is used to insert a variable
    println("The larger number between 15 and 30 is ${max(15, 30)}.") // Prints "Th larger number between 15 and 30 is 30." You can use braces ({}) to insert a function call into a string
}

/**
 * This function takes in two integers and returns the greater of the two
 */
fun max(n1: Int, n2: Int): Int { // Types are given after the name, if at all, in Kotlin
    // This inline if statement acts like the ternary operator in Java
    return if (n1 > n2) n1 else n2
}

/**
 * This function is the same as the one above. The difference is that this function is declared in a neater way since the body is a single expression
 */
fun betterMax(n1: Int, n2: Int): Int = if (n1 > n2) n1 else n2

/**
 * This function is also the same. Since it consists of a single expression, the return type does not need to be specified
 */
fun evenBetterMax(n1: Int, n2: Int) = if (n1 > n2) n1 else n2