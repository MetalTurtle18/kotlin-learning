package chapter7

fun main() {
    val rect1 = Rectangle(5, 4) // Area = 20
    val rect2 = Rectangle(7, 2) // Area = 14
    println(rect1 + rect2) // Prints the sum of their areas (34)
    println(rect1 * 3) // 5 -> 15; 4 -> 12
    println(-rect2) // 7 -> -7; 2 -> -2
    var rect3 = Rectangle(6, 3)
    println(++rect3) // 6 -> 7, 3 -> 4
}

data class Rectangle(val width: Int, val height: Int) {
    operator fun plus(other: Rectangle) = width * height + other.width * other.height // This makes the + operator sum the areas of each rectangle
}

operator fun Rectangle.times(scale: Int) = Rectangle(width * scale, height * scale) // Operators can be changed as extension functions too

operator fun Rectangle.unaryMinus() = Rectangle(-width, -height)

operator fun Rectangle.inc() = Rectangle(width + 1, height + 1) // inc operator works for both ++var and var++