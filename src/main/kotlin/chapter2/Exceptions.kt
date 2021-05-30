package chapter2

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.util.*

fun main() {
    println(favoriteCardinalDirection("north")) // Prints "You like the direction north"
    try {
        println(favoriteCardinalDirection("up")) // Doesn't print anything and throws an exception
    } catch(e: IllegalArgumentException) { }

    println(getUserAge()) // Prompts the user for their age and gives null if they don't give a number
}

/**
 * Simple method to demonstrate throwing exception in Kotlin
 */
fun favoriteCardinalDirection(dir: String) = // No need to specify "throws" in Kotlin—there are no checked exceptions in Kotlin
    if (dir in arrayOf("north", "east", "south", "west"))
        "You like the direction $dir"
    else
        throw IllegalArgumentException("\"$dir\" isn't a valid direction!") // This is thrown if the input isn't a direction

/**
 * Simple method with try that gets the user age
 */
fun getUserAge(): Int? {
    val scan = Scanner(System.`in`)
    return try { // Kotlin's try can be used as an expression. The last line of the body will be the value
        Integer.parseInt(scan.nextLine())
    } catch (e: NumberFormatException) {
        null
    } finally {
        scan.close()
    }
}