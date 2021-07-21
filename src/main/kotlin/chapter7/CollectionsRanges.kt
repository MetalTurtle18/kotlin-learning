package chapter7

fun main() {
    val rect1 = Rectangle(8, 9) // Rectangle from other file
    println(rect1["w"]) // Convention to get operator
    println(rect1["height"]) // Convention to get operator
    val rect2 = MutableRectangle(8, 9)
    println(rect2)
    rect2["width"] = 15 // Convention to set operator
    println(rect2)
    println(Point(5, 4) in rect1) // True because it is inside the rectangle
    println(Point(7, 11) in rect1) // False because it is outside the rectangle

    // Sinusoid class from other file
    val rangeOfWaves =
        Sinusoid(5, 6)..Sinusoid(12, 4) // Since this class implements Comparable, a range can be made from it
    println(Sinusoid(7, 2) in rangeOfWaves) // True because the amplitude is in the range
    println(Sinusoid(15, 1) in rangeOfWaves) // False because the amplitude is not in the range

    // Iterator through a rectangle returning each point along it's top edge
    for (p in Rectangle(7, 4))
        print("$p ")
}

operator fun Rectangle.get(dim: String) = when (dim.lowercase()) {
    "width", "w" -> width
    "height", "h" -> height
    else -> throw IndexOutOfBoundsException("Invalid dimension: $dim")
}

data class MutableRectangle(var width: Int, var height: Int)

operator fun MutableRectangle.set(dim: String, value: Int) = when (dim.lowercase()) {
    "width", "w" -> width = value
    "height", "h" -> height = value
    else -> throw IndexOutOfBoundsException("Invalid dimension: $dim")
}

data class Point(val x: Int, val y: Int)

// Overloading in operator
operator fun Rectangle.contains(p: Point) = p.x in 0..width && p.y in 0..height

// Iterator convention to use in for loops
operator fun Rectangle.iterator() = object : Iterator<Point> {
    var current = 0

    override fun hasNext() = current <= this@iterator.width

    override fun next() = Point(current++, this@iterator.height)
}