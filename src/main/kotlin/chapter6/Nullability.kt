package chapter6

fun main() {
    // strLength(null) will not compile because the input type is not nullable
    println(strLength("Hello")) // Works fine
    println(strLengthNullable("Hello"))
    println(strLengthNullable(null)) // Is allowed because the input type is a nullable String

    val turkeySandwich = Sandwich("Turkey", null)
    println(turkeySandwich.sauce?.length) // This will print null if the sauce is null
    println(turkeySandwich.sauce?.length ?: "no sauce") // Elvis operator to give a value if the sauce length is null

    printSandwichMeatButAnyType(turkeySandwich)
    printSandwichMeatButAnyType("this isn't a sandwich")

    val str: String? = "Hello"
    // println(str.length) will not compile because str is nullable
    println(str!!.length) // This is allowed because of the not null assertion operator. It will throw a NullPointerException if the value is null

    val bob: String? = "Bob"
    // greet(bob) will not compile because greet expects a non-nullable string
    bob?.let { greet(it) } // Let function runs code in the lambda if bob is not null
    val nobody: String? = null
    nobody?.let { greet(it) } // Nothing will happen

    val toyota = Car(10000.00)
    // println(toyota.owner) throws an exception at runtime because the lateinit property was not yet declared
    toyota.buy("Jimmy")
    println(toyota.owner) // Now this works

    println(turkeySandwich.meatUppercase())
    val nullSandwich: Sandwich? = null
    println(nullSandwich.meatUppercase()) // extension for nullable type

    printThing(null) // Works
    // printThingNotNull(null) won't compile because the parameter can't be nullable
    printThingNotNull("Not null String")

    /*
    Types from Java code are platform types: the compiler doesn't know if they are nullable or not. They can be treated either way.
    Syntax for platform types: String! (cannot be used in code but is shown by the compiler or IDE sometimes)
     */
}

fun strLength(str: String) = str.length // The input cannot be null since this is a non-nullable String type

fun strLengthNullable(str: String?) = str?.length // Safe call to length

fun printSandwichMeatButAnyType(s: Any?) = println(
    (s as? Sandwich)?.meat
        ?: "Not a sandwich" // Using safe cast to cast to a sandwich and elvis operator to print for other case
)

fun greet(name: String) = println("Hello, $name!")

// You can have extension functions with nullable receivers
fun Sandwich?.meatUppercase() = this?.meat?.uppercase() ?: "NO MEAT"

//                    V doesn't have a ? but still nullable
fun <T> printThing(t: T) = println(t?.hashCode()) // Print null if the value is null

//       V not nullable so the parameter is not nullable
fun <T: Any> printThingNotNull(t: T) = println(t.hashCode())

class Sandwich(val meat: String, val sauce: String?)

class Car(val price: Double) {
    lateinit var owner: String // lateinit allows this to be declared with no value but still not nullable

    fun buy(buyer: String) {
        owner = buyer
    }
}