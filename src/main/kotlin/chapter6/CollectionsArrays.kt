package chapter6

fun main() {
    val list1: List<Int> = listOf(1, 2, 3) // List cannot be null and cannot contain null items
    val list2: List<Int?> = listOf(1, null, 3) // List cannot be null but can contain null items
    val list3: List<Int>? = null // List can be null (but cannot contain null items)

    println(list2)
    println(list2.filterNotNull()) // Library function to remove null values and turn list from List<Int?> to List<Int>

    // Arrays
    val nullArray: Array<String?> = arrayOfNulls(20) // Initialize an array with all null elements of size 20
    println(nullArray.joinToString(separator = " "))
    val numArray =
        Array(20) { it.toString() } // Initialize an array of Strings with a lambda to make each element the index of that element
    println(numArray.joinToString(separator = " "))

    val arrayOfIntegers = arrayOf(1, 2, 3) // Array of Integer class
    val arrayOfInts = intArrayOf(10, 21, 32, 43, 54, 65) // Array of primitive int
    arrayOfInts.filter { it % 2 == 0 } // Collection methods work for arrays too (they return lists, not arrays)
        .forEachIndexed { i, n ->
            println("Index $i is $n")
        }
}