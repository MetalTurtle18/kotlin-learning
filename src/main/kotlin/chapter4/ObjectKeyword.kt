package chapter4

import java.awt.Color

fun main() {
    println(PayRoll.calculateTotalSalary()) // Access this non-static method without an instance because the object keyword creates a single instance of the class
    PayRoll.employees.add(Employee("Bob", 1000000000)) // Bob gets paid a lot
    PayRoll.employees.add(Employee("Joe", 50)) // Joe doesn't
    println(PayRoll.calculateTotalSalary())

    val class1 = FakeStatic("good afternoon")
    val class2 = FakeStatic("good morning")
    println(class1.greeting)
    println(class2.greeting)
    println(FakeStatic.text) // Can access this as if it were static because of the companion object

    // val greenBird = Bird(Color.GREEN) // not allowed because it has a private constructor
    val bird1 = Bird.newBlueBird()
    val bird2 = Bird.newRedBird()
    println(bird1.color)
    println(bird2.color)

    makeSpeak(object : Speaker {
        override fun speak(): String = "Something!"

    }) // Will print "Something!"
    // Equivalent to Java's anonymous classes:
    /*
    makeSpeak(new Speaker() {
        @Override
        public String speak() {
            return "Something!";
        }
    });
     */
}

object PayRoll {
    val employees = arrayListOf<Employee>()

    fun calculateTotalSalary(): Int {
        var total = 0;
        for (employee in employees)
            total += employee.salary
        return total
    }
}


class Employee(val name: String, val salary: Int)

class FakeStatic(val greeting: String) {
    companion object {
        val text = "Hello"
    }
}

// This Bird class now has "static" factory methods to get new instances of itself
class Bird private constructor(val color: Color) {
    companion object {
        fun newRedBird() = Bird(Color.RED)

        fun newBlueBird() = Bird(Color.BLUE)
    }
}

// This can be used in another function below
interface Speaker {
    fun speak(): String
}

// This function required an implementation of the Speaker interface
fun makeSpeak(speaker: Speaker) = println(speaker.speak())