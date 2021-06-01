package chapter3

import java.util.*

fun main() {
    println("message".twice()) // Prints "messagemessage"; Can be called like a function of the String type
    // To use this in Java you would do: ExtensionsKt.twice("message");
    // Extensions become static methods from the file they are in in Kotlin

    val testList = listOf(1, 2, 3, 4, 5) // I will use this for testing the methods
    println(testList.joinToString(prefix = "list: "))

    println("Kotlin".firstChar) // Prints "K"
}

/**
 * Extension function to return two of a String. String is the receiver type and the receiver object is what I call it on
 */
fun String.twice() = "$this$this"

/**
 * This method is like the one from the previous section, except it is an extension function now
 */
fun <T> Collection<T>.joinToString(separator: String = ", ", prefix: String = "", suffix: String = ""): String {
    val output = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) output.append(separator)
        output.append(element)
    }
    output.append(suffix)
    return output.toString()
}

/**
 * Extension property for String class
 */
val String.firstChar: Char
    get() = this[0]