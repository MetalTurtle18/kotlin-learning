package chapter3

fun main() {
    val testThing = Thing(5, "five")
    testThing.function()
}

/**
 * Nonsensical class
 */
class Thing(val number: Int, val string: String) {
    /**
     * Nonsensical function
     */
    fun function() {
        /**
         * Inner function can access outside itself
         */
        fun printIt(extra: String) {
            println("$extra, $string, $number")
        }
        printIt("hello")
        printIt("goodbye")
    }
}