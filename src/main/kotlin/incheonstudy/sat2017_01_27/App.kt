package incheonstudy.sat2017_01_27

import java.lang.reflect.Field
import java.lang.reflect.Method
import kotlin.reflect.KFunction1
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KProperty0
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter


var x = 1
val y = 2

data class Person(val name: String, val age: Int)

val String.lastChar: Char
    get() = this[length - 1]
fun main(args: Array<String>) {
    val a: KMutableProperty0<Int> = ::x
    val b: KProperty0<Int> = ::y
    println(a.get())
    a.set(321)
    println(a)
    println(::x.get())
    ::x.set(3)
    println(x)

    println(::y.get())
    // not valid
    //::y.set(23)

    // members
    val strings = "this is fun".split(' ')
    println(strings.map(String::length))

    val person = Person("", 33)

    val age = Person::age
    println(age.get(person))

    // works with extension properties
    val ls = String::lastChar
    println(ls.get("hello"))

    // java reflection interop
    var javaGetter: Method? = Person::age.javaGetter
    var field: Field? = Person::age.javaField

    println(javaGetter)
    println(field)

}
fun odd (x : Int) : Int { return x}
var fun1: KFunction1<Int, Int> = ::odd