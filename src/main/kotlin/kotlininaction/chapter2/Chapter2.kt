package kotlininaction.chapter2

import kotlin.reflect.KClass

open class Base(x: Int)
class Derived(x: Int): Base(x)

fun process(b: Base) {
    if (b is Derived) {
        println(b::class.qualifiedName)
    }
}

data class Ch2Person(val name: String, val age: Int){
    companion object {
        val some = "gg"
    }
    fun getsome() = some
}


var test: String = "it's string"


fun main(args: Array<String>) {
    val c: KClass<Ch2Person> = Ch2Person::class
    println(c.qualifiedName)
    println(c.members.map { it.name })
    println(c.isCompanion)
    println("!!!!!!!!!!!!!")

    val j = c.java
    println(j.simpleName)
    println(j.methods.map { it.name })

    val z: Base = Derived(123)
    process(z)
}