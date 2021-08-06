package chapter7

import kotlin.reflect.KProperty

fun main() {
    val a = NoDelegationTest()
    println(a.e) // Takes 3 seconds because the getter takes that time
    println(a.e) // Doesn't take 3 seconds

    val b = LazyDelegationTest()
    println(b.e) // Takes 3 seconds because the lazy delegation has to run the function
    println(b.e) // Doesn't take 3 seconds

    val c = DelegationTest()
    println(c.e)
    c.e = "changed"
    println(c.e)

    val d = DelegationTest2()
    println(d.e)
    println(d.f)
    d.e = "kotlin"
    d.f = "python"
    println(d.e)
    println(d.f)
}

class NoDelegationTest {
    // This ensures the time-consuming function to get the value is only run when necessary
    private var _e: String? = null
    val e: String
        get() {
            if (_e == null)
                _e = getTheValue()
            return _e!!
        }

    private fun getTheValue(): String {
        Thread.sleep(3000L) // Pretend this is doing some database operation
        return "something"
    }
}

class LazyDelegationTest {
    // Functionally the same thing as the other class. The expensive function is called only on the first access, and not again
    val e: String by lazy { getTheValue() }

    private fun getTheValue(): String {
        Thread.sleep(3000L) // Pretend this is doing some database operation
        return "something else"
    }
}

class DelegationTest {
    var e: String by MyDelegate() // Delegated property to the MyDelegate class
}

class DelegationTest2 {
    var e: String by TwoTypeDelegate.javaType() // Delegated property can be a function that returns a class with the two convention operators
    var f: String by TwoTypeDelegate.scalaType() // Delegated property can be a function that returns a class with the two convention operators
}

class MyDelegate {
    private var value = "example"
    operator fun getValue(str: DelegationTest, prop: KProperty<*>) =
        "The value of ${prop.name} is $value" // The value is given as a full sentence instead of just the value

    operator fun setValue(str: DelegationTest, prop: KProperty<*>, newValue: String) {
        println("Changed the value of ${prop.name} from $value to $newValue") // When the value is set, the change is printed to the console
        value = newValue
    }
}

class TwoTypeDelegate private constructor(var value: String) {
    operator fun getValue(str: DelegationTest2, prop: KProperty<*>) =
        "The value of ${prop.name} is $value" // The value is given as a full sentence instead of just the value

    operator fun setValue(str: DelegationTest2, prop: KProperty<*>, newValue: String) {
        println("Changed the value of ${prop.name} from $value to $newValue") // When the value is set, the change is printed to the console
        value = newValue
    }

    companion object {
        fun javaType() = TwoTypeDelegate("java")
        fun scalaType() = TwoTypeDelegate("scala")
    }
}