package incheonstudy.sat2017_01_20

fun isOdd(x: Int) = x % 2 != 0
fun isOdd(s: String) = s == "weired" || s == "strange" || s == "peculiar"

fun main(args: Array<String>) {
    val numbers = generateSequence(1, { it + 3 }).take(5)
    println(numbers.filter { isOdd(it) }.toList())
    println(numbers.filter (::isOdd).toList())

    val predicate: (String) -> Boolean = ::isOdd
    println(predicate("weired"))

    val str = "this is a fun experiment".split(' ')
    val oddLength = compose(::isOdd, String::length)
    println(str.filter(oddLength))
}

fun <Int, Boolean, String> compose(f: (Boolean) -> String, g: (Int) -> Boolean): (Int) -> String {
    return { x -> f(g(x))}
}