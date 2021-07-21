package chapter7

fun main() {
    val sin1 = Sinusoid(4, 100)
    val sin2 = Sinusoid(1, 500)
    println(sin1 < sin2) // False because sin1 has a larger amplitude
    val sinWaves = listOf(
        Sinusoid(1, 100),
        Sinusoid(5, 100),
        Sinusoid(3, 100),
        Sinusoid(2, 100),
        Sinusoid(7, 100),
        Sinusoid(4, 100)
    )
    println(sinWaves.sorted()) // A list of Sinusoid objects can be sorted because it implements Comparable
}

data class Sinusoid(val amplitude: Int, val frequency: Int) : Comparable<Sinusoid> {
    // This function compares each wave's amplitude
    override fun compareTo(other: Sinusoid): Int { // Override compareTo method, which can be called using >, >=, <, <=
        return amplitude - other.amplitude
    }
}