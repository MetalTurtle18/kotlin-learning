package chapter2

import java.util.*

fun main() {
    // Simple while loop. Pretty much the exact same thing as Java
    var x = 1
    while (x <= 10) {
        println(x)
        x++
    }

    for (i in 1..100) { // This range goes from 1 to 100 inclusive. This is similar to Python's "range" function
        print(fizzBuzz(i))
    }
    println()
    for (i in 300 downTo 200 step 3) { // Goes from 300 to 200, inclusive, only doing every third number. Similar to Python "range(300, 199, 3);
        print(fizzBuzz(i))
    }
    println()

    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'M') { // Ranges work with chars, not only integers
        val binary = Integer.toBinaryString(c.code)
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps) { // For loop iterating with multiple values
        println("$letter = $binary") // Print the binary representation of characters from A to M
    }

    val fruits = arrayListOf("apple", "banana", "cantaloupe", "date", "elderberry", "fig", "grape")
    for ((index, fruit) in fruits.withIndex()) { // Use withIndex to iterate through a list with both the elements of the list and the index of each element
        println("$fruit is the $index fruit in this list")
    }

    println("pineapple" in fruits) // Prints false because "pineapple" is not in the list of fruits
    println("banana" in fruits) // Prints true because "banana" is in the list of fruits
    println(4 in 2..6) // Prints true because 4 is between 2 and 6
    println("crab" in "bear".."zebra") // Prints true because crab is in between bear and zebra alphabetically (which is how strings compare)
}

/**
 * Function using when to return the proper String when given a number
 */
fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}