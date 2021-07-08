package chapter5

fun main() {
    val things = listOf(
        Thing("Table", 5.0),
        Thing("Rock", 1.5),
        Thing("Chair", 2.0),
        Thing("House", 50.0),
        Thing("Tree", 2.0)
    )

    // These two produce the same result but the first one does not create intermediate objects
    println(things.asSequence()
        .map(Thing::name)
        .filter { it.startsWith("T") }
        .toList()) // A sequence processes all operations (map, filter) on it at once per item instead of one operation at a time for the entire collection

    println(things.map(Thing::name)
        .filter { it.startsWith("T") }
        .toList())

    val evenSequence = generateSequence(2) { it + 2 } // Sequence of even numbers
    println(evenSequence.takeWhile { it <= 100 }.toList()) // Prints even numbers up to 100
}
