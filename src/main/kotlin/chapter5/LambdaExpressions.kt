package chapter5

fun main() {
    val people = listOf(
        Person(10),
        Person(11),
        Person(3),
        Person(40),
        Person(75),
        Person(23),
        Person(31)
    )
    println(findOldestPerson(people)?.age) // Calls simple for loop function to find oldest (75 years old)
    println(people.maxByOrNull { it.age }?.age) // Calls a function maxByOfNull and gives a function as the parameter. Ends up with the same result
    println(people.maxByOrNull(Person::age)?.age) // Same as above accept using a member reference

    val repeatLambda = { x: Int, str: String -> str.repeat(x) }
    println(repeatLambda(4, "test ")) // Calls the lambda stored as a variable

    println(people.joinToString(separator = " & ", transform = { "${it.age}yrs old" })) // The joinToString method can also take a function argument. Also, "it" keyword is used for lambda parameter in a lambda with only one input

    val strings = listOf(
        "Java",
        "Kotlin",
        "Scala"
    )
    printStringsWithPrefix(strings, "Language: ")
    printStringsNumberedWithPrefix(strings, "Language: ")

    val newPerson = ::Person // constructor reference to create a new person
    val p1 = newPerson(30)
    println(p1.age)
}

/**
 * Finding oldest person in a list by for loops
 */
fun findOldestPerson(people: List<Person>): Person? {
    var maxAge = 0
    var oldestPerson: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            oldestPerson = person
        }
    }
    return oldestPerson
}

class Person(val age: Int)

fun printStringsWithPrefix(strings: Collection<String>, prefix: String) {
    strings.forEach {
        println("$prefix $it") // Accessing things outside the lambda (doable in java)
    }
}

fun printStringsNumberedWithPrefix(strings: Collection<String>, prefix: String) {
    var number = 1
    strings.forEach {
        println("$number) $prefix $it") // Accessing non-final things outside the lambda (not doable in java)
        number++
    }
}