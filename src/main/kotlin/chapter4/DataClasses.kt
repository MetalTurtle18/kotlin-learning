package chapter4

fun main() {
    val testClient = Client("Fred", 12345)
    println(testClient) // Calls the toString method
    val testClient2 = Client("Fred", 12345)
    println(testClient == testClient2) // Prints true. Kotlin == compiles to .equals()

    // This code works the same
    val testBetterClient = BetterClient("Bob", 98765)
    println(testBetterClient)
    val testBetterClient2 = BetterClient("Bob", 98765)
    println(testBetterClient == testBetterClient2)

    val testSet = CountingSet<Int>()
    testSet.addAll(listOf(1, 1, 2, 3, 3, 3, 4, 5))
    testSet.add(5)
    // 9 items were added, but only 5 different ones
    println("The set has ${testSet.size} items but ${testSet.objectsAdded} items were added")
}

class Client(val name: String, val postalCode: Int) {
    override fun toString() = "Client(name=$name, postalCode=$postalCode)"

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode() = name.hashCode() * 31 + postalCode // Now the Client class can work in optimized hashsets and other collections
}

data class BetterClient(val name: String, val postalCode: Int) // This is like the class above except it generates the three methods automatically

// Class delegation
// "Extending" a HashSet by implementing the original interface and storing the HashSet as a field. Kotlin does this automatically with this syntax
class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {
    var objectsAdded = 0

    // Now this class has special HashSet methods
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}