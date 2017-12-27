package com.github.minichicken

interface Clickable{
    fun click()
    fun showOff() = println("this is clickable!")
}

interface Focusable{
    fun setFocus(focus: Boolean) = if (focus) println("I got focus") else println("I missed focus")
    fun showOff() = println("this is focusable!")
}

//in kotlin, use extends and implements after class name with :
class Button4: Clickable, Focusable {
    override fun click() {
        println("clicked!")
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

//class Person4 private constructor(val name: String, val age: Int)
//class Person4 constructor(val name: String, val age: Int) // 기본형 constructor는 생략 가능
class Person4(private val name: String, private val age: Int){
    var email: String = "non email person"
    constructor(name: String, age: Int, email: String): this(name, age) { //val var 미정의
        this.email = email
    }
    init {
        println("init class")
    }
    companion object { //static objects
        fun sum(x: Int, y: Int): Int{
            return x + y
        }
        fun getInstance() = Person4("static Jaeho", 19)
    }
    fun showMe(){
        println("Name: $name, Age: $age")
    }
    fun showEmail(){
        println(this.email)
    }
}

open class Extender(private val age: Int) { //abstract class Extender
    fun ageString(): String{
        return "Age: $age"
    }
    open fun emailString(email: String): String{
        return email
    }
}
class UseExtender(age: Int): Extender(age), Clickable{
    override fun emailString(email: String): String {
        super.emailString(email)
        email.plus("@gmail.com")
        return email
    }

    override fun click() {
        println("age: what?")
    }

}

fun main(args: Array<String>){
    val button = Button4()
    button.showOff()
    button.setFocus(true)
    button.click()
    val person0 = Person4("Jaeho Lee", 19)
    person0.showMe()
    val person1 = Person4("Jaeho Lee", 19, "mini.chicken.dev@gmail.com")
    person1.showMe()
    person1.showEmail()
    println(Person4.sum(3, 6))
    val staticPerson = Person4.getInstance()
    staticPerson.showMe()
    val extender = UseExtender(19)
    extender.ageString()
    extender.click()
    println(extender.emailString("mini.chicken.dev"))
}
