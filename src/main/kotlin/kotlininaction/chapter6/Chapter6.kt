package kotlininaction.chapter6

import java.io.File
import java.time.LocalDate

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        object : Iterator<LocalDate> {
            var current = start

            override fun hasNext() =
                    current <= endInclusive

            override fun next() = current.apply {
                current = plusDays(1)
            }
        }

data class Point(val x: Int, val y: Int)

operator fun Point.minus(other: Point): Point{
    return Point(this.x + other.y, this.y + other.x)
}

const val path = "/opt"
val something: File by lazy {
    File(path)
}

fun main(args: Array<String>) {
    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }
    val x = Point(2 ,4)
    val y = Point(3,1)
    println(x - y)
    something.absoluteFile
}
