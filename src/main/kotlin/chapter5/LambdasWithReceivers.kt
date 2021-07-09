package chapter5

fun main() {
    println(alphabet()) // Works just fine
    println(alphabetWithReceiver()) // Works the same
    println(alphabetExpressionBody()) // Also works the same
    println(alphabetApply()) // Also works the same
    println(alphabetBuildString()) // Also works the same
}

fun alphabet(): String {
    val output = StringBuilder()
    for (c in 'A'..'Z')
        output.append(c)
    output.append("\nNow I know my ABCs")
    return output.toString()
}

fun alphabetWithReceiver(): String {
    val output = StringBuilder()
    return with(output) { // "with" is technically a function that takes a lambda as its second argument
        for (c in 'A'..'Z')
            append(c) // Able to call methods from "output" as if this were inside it
        append("\nNow I know my ABCs") // Same here
        toString() // Same here; returns this as last part of the lambda expressions
    }
}

// This version of the function doesn't need a variable to store the StringBuilder
fun alphabetExpressionBody() = with(StringBuilder()) {
    for (c in 'A'..'Z')
        append(c)
    append("\nNow I know my ABCs")
    toString()
}

fun alphabetApply() = StringBuilder().apply {
    for (c in 'A'..'Z')
        append(c)
    append("\nNow I know my ABCs")
}.toString() // Instead of returning the lambda result, the apply function returns the receiver object

fun alphabetBuildString() = buildString {  // This function internally applies the lambda passed to a StringBuilder object, making it a more compact syntax for using a StringBuilder
    for (c in 'A'..'Z')
        append(c)
    append("\nNow I know my ABCs")
}