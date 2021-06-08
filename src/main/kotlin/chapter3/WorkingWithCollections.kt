package chapter3

import java.lang.StringBuilder

fun main() {
    printDoubleEachNumber(4) // Prints 8
    printDoubleEachNumber(4, 5, 6, 7) // Prints 8, 10, 12, and 14

    val items = arrayOf("apple", "pear", "kiwi", "orange")
    // val fullList = listOf("Items: ", list) // This will not work because the array cannot be passed in to the vararg
    val fullList = listOf("Items: ", *items) // This uses the spread operator to change the array into a bunch of Strings
    println(fullList)

    println(5 times "abc") // Uses infix function to print "abcabcabcabcabc"
    println(10 times "10 ") // Uses infix function to print "10 10 10 10 10 10 10 10 10 10 "

    val (str, i) = "something" to 50 // Use a destructing declaration to declare to values at once. This can be used in for loops with "withIndex"
    println("You chose the String $str and the number $i")
}

/**
 * This function uses varargs to take in any number of integers and print double each one
 */
fun printDoubleEachNumber(vararg numbers: Int) {
    for (n in numbers) {
        println(2*n)
    }

}

/**
 * This infix function returns the string repeated a given number of times
 */
infix fun Int.times(str: String): String {
    val builder = StringBuilder()
    for (i in 1..this)
        builder.append(str)
    return builder.toString()
}