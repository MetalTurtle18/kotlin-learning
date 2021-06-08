package chapter3

fun main() {
    val str = "192.168.1.10" // An example String

    println(str.split(".")) // In Java this would return an empty array since "." would be treated as a regular expression
    println(str.split(".".toRegex())) // This is a blank array in Kotlin because it is passed an actual Regex object
    println(str.split("""\.1""".toRegex())) // Splits by ".1"; Also, triple quoted string means no escape characters are necessary
}