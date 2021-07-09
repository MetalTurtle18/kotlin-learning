package chapter5

fun main() {
    // You can pass lambdas as functional interfaces to Java methods and the compiles will figure out the intended type
    val runnable = Runnable { println("Hello") } // This lambda is explicitly compiled to the Runnable functional interface type
}
