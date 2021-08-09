package chapter8

fun main() {
    val functionExample = // Kotlin type inference figures out the type of this lambda
        { n1: Int, n2: Int -> println(n1 + n2) }
    val functionTypeExample: (Int, Int) -> Unit = // This is the actual type written out
        { n1, n2 -> println(n1 + n2) } // Also, type of inputs are not included because they are specified already
    val noInputFunction: () -> Unit = // If there are no inputs, an empty set or parenthesis is required
        { println("Hello, world!") }
    val functionWithNullableReturnType: (Int, Int) -> Int? = { _, _ -> null } // Return type is null
    val nullableFunction: ((Int, Int) -> Int)? =
        null // Here, the entire function can be null because of the parenthesis

    functionExample(1, 2) // Call a lambda by putting parenthesis
    noInputFunction.invoke() // Alternatively, call the invoke method on the lambda
    println(functionReturningFunction("asdf")(5)) // Calling the resulting lambda function from the function

    val numbersList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
    val evenV1 = numbersList
        .filter { it % 2 == 0 } // Only evens
        .map { it * it } // Squared
        .takeWhile { it <= 100 } // Stop when one is greater than 100
    // This is the same thing with only a slight change. This duplicate code can be eliminated with a function
    val oddV1 = numbersList
        .filter { it % 2 != 0 } // Only odds
        .map { it * it } // Squared
        .takeWhile { it <= 100 } // Stop when one is greater than 100
    // These two do the same things except with the function
    val evenV2 = numbersList.squaredUnderHundred { it % 2 == 0 }
    val oddV2 = numbersList.squaredUnderHundred { it % 2 != 0 }
    println(evenV1)
    println(evenV2)
    println(oddV1)
    println(oddV2)
}

// This function returns another function
fun functionReturningFunction(start: String): (Int) -> String = { "$start$it" }

// Function takes a lambda predicate
fun List<Int>.squaredUnderHundred(predicate: (Int) -> Boolean) =
    filter(predicate).map { it * it }.takeWhile { it <= 100 }