package chapter2

import java.awt.Color
import java.lang.IllegalArgumentException
import kotlin.math.exp

fun main() {
    println("One serving of cheese is ${Food.CHEESE.calories} calories so 3 servings are ${Food.CHEESE.caloriesPerAmount(3)} calories.") // Prints "One serving of cheese is 50 calories so 3 servings are 150 calories"
    println("A full meal with water and a cheeseburger will be ${Food.HAMBURGER.calories + Food.CHEESE.calories + Food.WATER.calories} calories") // Prints "A full meal with water and a cheeseburger will be 550 calories"

    println("The use of cheese is: ${getUse(Food.CHEESE)}.") // Prints "The use of cheese is: Use for topping pizza or pasta."

    println(eval(Sum(Sum(Num(12), Sum(Num(7), Num(2))), Num(9)))) // Prints (12 + (7 + 2)) + 9, which equals 30

    println(evalWithWhen(Sum(Sum(Num(12), Sum(Num(7), Num(2))), Num(9)))) // This should print the same thing: 30
}

/**
 * Example enum
 *
 * (These values are made up)
 */
enum class Food(val calories: Int, val color: Color) { // Similar to class with properties, an enum class can do the same
    WATER(0, Color.BLUE),
    CHEESE(50, Color.ORANGE),
    HAMBURGER(500, Color(129,105,72));

    // Method within enum
    fun caloriesPerAmount(servings: Int) = servings * calories
}

/**
 * This function makes use of the when expression in Kotlin. It is very similar to the Java switch statement, but it can, like Kotlin's if, be used as an expression
 */
fun getUse(food: Food) = when (food) {
    Food.WATER -> "Drink lots of it to stay alive"
    Food.CHEESE -> "Use for topping pizza or pasta"
    Food.HAMBURGER -> "Grill for a party"
    else -> "That isn't a food" // "else" instead of "default"
}

// These three objects will be used to do some math with functions
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

/**
 * This function evaluates a bunch of expressions recursively using smart casts
 */
fun eval(expr: Expr): Int {
    if (expr is Num) // When we check if expr is of type Num, it automatically casts it to that type
        return expr.value // Then its property "value" can be accessed
    if (expr is Sum) // Same thing down here
        return eval(expr.left) + eval(expr.right)
    throw IllegalArgumentException("Something was screwed up") // In case it is neither of these somehow
}

/**
 * This is the same as the function above but uses when instead
 */
fun evalWithWhen(expr: Expr) =
    when (expr) {
        is Num -> expr.value // The type can be checked as a branch of a when expression
        is Sum -> eval(expr.left) + eval(expr.right)
        else -> throw IllegalArgumentException("Something was screwed up") // Here else is used in case expr is not either of the types it is supposed to be
    }

/**
 * When expressions can also have blocks in branches:
 *
 * when (something) {
 *     branch -> {
 *         code()
 *         moreCode()
 *     }
 * }
 */