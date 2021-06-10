package chapter4

import java.awt.Color

fun main() {
    val bob = Human("Bob") // Instantiate a class in Kotlin without "new" keyword like in Java
    val bill = Human("Bill", isSleeping = true)
    println("Is ${bob.name} sleeping: ${bob.isSleeping}.")
    println("Is ${bill.name} sleeping: ${bill.isSleeping}.")
}

/**
 * Class with default constructor for two parameters
 */
class Human(val name: String, val isSleeping: Boolean = false)

open class Programmer(val language: String)
class KotlinProgrammer() : Programmer("Kotlin") // The superclass is written with values for its constructor

open class SomeButton
class CircleButton : SomeButton() // The superclass has to have empty parenthesis because it has an empty constructor

class Secret private constructor() // This class cannot be instantiated because it has a private constructor

open class Thing {
    val mass: Double
    val color: Color

    // These constructors aren't necessary since you can give default values in Kotlin, but they show how to have multiple secondary constructors
    constructor(_mass: Double) {
        mass = _mass
        color = Color.WHITE
    }

    constructor(_mass: Double, _color: Color) {
        mass = _mass
        color = _color
    }

    // Constructor delegated to another one of the same class
    constructor(): this(10.0, Color.WHITE)
}

interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User // Simple class that sets the property from the constructor

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore('@') // More complicated property getter that takes the email name
}

class FacebookUser(val accountId: Int) : User {
    override val nickname = getFacebookName(accountId) // This property is set to a completely different value obtained from another function

    // Pretend this actually does something
    private fun getFacebookName(id: Int) = "bob$id"
}