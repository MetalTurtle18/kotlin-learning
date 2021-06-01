package chapter3

fun main() {
    val testList = listOf(1, 2, 3, 4, 5) // I will use this for testing the methods
    println(joinToString1(testList, ";", "(", ")")) // It is tricky to know which parameter is which (of course IntelliJ can help, but it is not ideal)

    println(joinToString1(testList, separator = " ", prefix = "[", suffix = "]")) // First step to improving readability: named arguments. This can be done on the existing function

    println(joinToString2(testList)) // Uses all defaults
    println(joinToString2(testList,  "-")) // Specifies only one parameter
    println(joinToString2(testList, suffix = ")", prefix = "(")) // Parameters can be specified out of order if they are named
}

/**
 * This is the simplest version of this function
 */
fun <T> joinToString1(collection: Collection<T>, separator: String, prefix: String, suffix: String): String {
    val output = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) output.append(separator)
        output.append(element)
    }
    output.append(suffix)
    return output.toString()
}

/**
 * This version of the function has default parameters
 */
fun <T> joinToString2(collection: Collection<T>, separator: String = ", ", prefix: String = "", suffix: String = ""): String { // Now the function has default parameters so they don't need to be specified
    val output = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) output.append(separator)
        output.append(element)
    }
    output.append(suffix)
    return output.toString()
}