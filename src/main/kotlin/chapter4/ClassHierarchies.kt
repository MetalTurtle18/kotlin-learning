package chapter4

import java.io.Serializable

// This is a large file, so I left comments about which sub-sub-chapter each section of code is from

fun main() {
    val testButton = Button()
    testButton.click()
    testButton.setFocus(true)
    testButton.setFocus(false)
    testButton.showOff()
}

// 4.1.1: Interfaces in Kotlin
/**
 * Create a new interface called Clickable
 */
interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable") // Default methods in interfaces don't need "default" keyword in Kotlin
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable")
}

/**
 * This class implements the Clickable interface
 */
class Button : Clickable, Focusable {
    override fun click() = println("I was clicked") // The "override" keyword is mandatory in Kotlin
    override fun showOff() { // It isn't required to implement this method since it had default behavior EXCEPT when there are multiple super interfaces that have the same method
        // Since each of the super interfaces has the same method, you need to specify which super type you are referring to
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

// 4.1.2: Open, final, and abstract modifiers: final by default
/**
 * This class can be extended by another class
 */
open class RichButton : Clickable { // Open keyword means it can be extended

    fun disable() { } // This method cannot be overridden

    open fun animate() { } // This method can be overridden

    final override fun click() { } // Now no subclasses of RichButton can override click()
}

/**
 * Abstract class cannot be instantiated but can be extended
 */
abstract class Animated {

    abstract fun animate() // This method is open because it should be overridden in its subclass

    open fun stopAnimating() { }

    fun animateTwice() { }
}

// 4.1.3: Visibility modifiers: public by default
/**
 * Internal class means it can be accessed only from within this module
 */
internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

//fun TalkativeButton.giveSpeech() { // This line won't compile because the class is internal but the function is public, exposing the class
//    yell() // Can't access this function because it is private
//    whisper() // Can't access this function because this is an extension function, not a subclass of TalkativeButton
//}

// 4.1.4: Inner and nested classes: nested by default

interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) { }
}

class Button2 : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) { }

    class ButtonState : State // This class is the equivalent of Java's "static" nested class

    inner class AnotherClass { // This class is the equivalent of a nested class in Java without the static modifier
        fun getOuterButton() = this@Button2 // This is how to access the outer class from an inner class
    }
}

// 4.1.5: Sealed classes: defining restricted class hierarchies

// This is the example from a previous chapter, but using sealed classes
sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}
fun eval(e: Expr): Int =
    when (e) { // Since the number of classes extending Expr is limited, no default branch is required
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
    }