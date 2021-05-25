package chapter2

/**
 * This is the main function to run all of the code from in this file
 */
fun main() {
    val spot = Dog("Spot", 5, false) // Create a new dog named spot
    println(spot.age) // Prints 5. The "age" property in the dog class is actually private. This calls the getter. If you were to use this Kotlin class in java, the code would look like "System.out.println(spot.getAge());"
    // Prints "You have a dog named Spot. He is 5 years old, so he is not a puppy."
    println("You have a dog named ${spot.name}. He is ${spot.age} years old, so he is ${if (spot.isPuppy) "" else "not "}a puppy.")

    val fido = BetterDog("Fido", 1) // Create a new "BetterDog" named fido
    println(fido.isPuppy) // Prints true. Even though it was not specified in the constructor, there is a custom getter for this property
    // Prints "You have a dog named Fido. He is 1 years old, so he is a puppy."
    println("You have a dog named ${fido.name}. He is ${fido.age} years old, so he is ${if (fido.isPuppy) "" else "not "}a puppy.")
}

// There are multiple classes in this one file and neither is named "ClassesProperties!" In Kotlin, this is ok.

/**
 * Kotlin class declaration is a lot more compact than Java's
 *
 * The parameters in the class header will be private fields, initialized in the constructor, with getters
 */
class Dog(
    val name: String,
    var age: Int, // This property can be changed since it is declared with "var"
    var isPuppy: Boolean
)

/**
 * This class will know whether the dog is a puppy by its age
 */
class BetterDog(val name: String, var age: Int) {
    val isPuppy: Boolean get() = age <= 2 // This is a custom property accessor.
}