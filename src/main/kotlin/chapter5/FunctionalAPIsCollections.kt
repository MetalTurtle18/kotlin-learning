package chapter5

fun main() {
    val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(numberList.filter { it % 2 == 0 }) // Filters list to only event elements using a lambda
    println(numberList.map { it * it }) // Maps each element of the list to its square using a lambda

    val things = listOf(
        Thing("Table", 5.0),
        Thing("Rock", 1.5),
        Thing("Chair", 2.0),
        Thing("House", 50.0)
    )
    println(things.filter { it.length > 3 }) // Prints all elements with a length greater than 3
    println(things.maxByOrNull(Thing::length)) // Uses member reference to find the biggest thing

    val isBiggerThanThree = { t: Thing -> t.length > 3 }
    println(things.all(isBiggerThanThree)) // False because they are not all bigger than three
    println(things.any(isBiggerThanThree)) // True because there are some things are bigger than three
    println(things.count(isBiggerThanThree)) // 2 because there are two things bigger than three
    println(things.find(isBiggerThanThree)) // "Table" Thing because it is the first element in the list that is bigger than three

    val things2 = listOf(
        Thing("Table", 5.0),
        Thing("Rock", 1.5),
        Thing("Chair", 2.0),
        Thing("Tree", 2.0),
        Thing("Bed", 5.0)
    )
    println(things2.groupBy(Thing::length)) // This becomes a Map<Double, List<Thing>> grouped by each thing's length

    val books = listOf(
        Book("Kotlin in Action", listOf("Dmitry Jemerov", "Svetlana Isakova")),
        Book("The Lorax", listOf("Dr. Seuss"))
    )
    println(books.map(Book::authors)) // Prints a list of lists of authors
    println(books.flatMap(Book::authors)) // Prints a single list of all authors combined
}

data class Thing(val name: String, val length: Double)

data class Book(val name: String, val authors: List<String>)