package chapter8

fun main() {
    // Using the inline keyword on a function makes it compile inline instead of calling the function
    printNumber(5) // Will compile to call the function
    printNumberInline(5) // Will compile to "println("Number: 5")"

    // Collections operations are inlined
}

fun printNumber(n: Int) = println("Number: $n")

inline fun printNumberInline(n: Int) = println("Number: $n") // This is a bad use of inline in practice. It should be used for functions with lambda parameters

inline fun function(lambdaOne: (() -> Unit) -> Unit, noinline lambdaTwo: () -> Unit) = lambdaOne(lambdaTwo) // noinline keyword prevents the argument from being inlined