package kotlininaction.chapter4

import java.io.File
import java.io.Serializable

interface Ch4Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Ch4Focusable {
    fun setFocus(focus: Boolean) = println("I ${if (focus)"got" else "lost"} focus")
    fun showOff() = println("I'm focusable!")
}

//in kotlin, use extends and implements after class name with :
//in kotlin class is default final open to extends

class Ch4Button: Ch4Clickable, Ch4Focusable {
    override fun click() = println("I was clicked!!!")

    override fun showOff() {
        super<Ch4Clickable>.showOff()
        super<Ch4Focusable>.showOff()
    }
}

open class  Ch4RichButton: Ch4Clickable {

    fun disable() {}

    open fun animate() {}

    override fun click() {

    }

    //final override fun click() {}
}

abstract class Animated {

    abstract fun animate()

    open fun stopAnimating() {}

    fun animateTwice() {}
}

interface Ch4State: Serializable // define 처럼 serializable 을 state처럼 쓰기 위함

interface Ch4View {
//    fun getcurrentState(): Ch4State
    fun restoreState(state: Ch4State)
}

class Ch4Button2: Ch4View {
  //  override fun getcurrentState(): Ch4State {
   //     return
   // }

    override fun restoreState(state: Ch4State) {

    }

    class Ch4ButtonState2: Ch4State {

    }
}

class Ch4Outer {
    inner class Ch4Inner {
        fun getOuterReference(): Ch4Outer = this@Ch4Outer
    }
}


interface Ch4Expr

class Ch4Num(val value: Int): Ch4Expr

class Ch4Sum(val left: Ch4Expr, val right: Ch4Expr): Ch4Expr

fun Ch4Eval(e: Ch4Expr): Int =
        when (e) {
            is Ch4Num -> e.value
            is Ch4Sum -> Ch4Eval(e.right) + Ch4Eval(e.left)
            else -> throw IllegalArgumentException("Unknown expression")
        }

sealed class Ch4Expr2 {
    class Ch4Num(val value: Int): Ch4Expr2()
    class Ch4Sum(val left: Ch4Expr2, val right: Ch4Expr2): Ch4Expr2()
}

fun Ch4Eval2(e2: Ch4Expr2): Int =
        when (e2) {
            is Ch4Expr2.Ch4Num -> e2.value
            is Ch4Expr2.Ch4Sum -> Ch4Eval2(e2.right) + Ch4Eval2(e2.left)
        }

//class Ch4User(val nickname: String)
class Ch4User constructor(_nickname: String) {
    val nickname: String
    //val nickname: String = _nickname

    init {
        nickname = _nickname
    }
}

class Ch4User2(val nickname: String, val isSubscribed: Boolean = true)

fun getFacebookName(accountid: Int) = "fb:$accountid"

interface Ch4User3 {
    val nickname: String
}

class Ch4PrivateUser(override val nickname: String): Ch4User3

class Ch4SubscribingUser(val email: String): Ch4User3 {
    override val nickname: String
        get() = email.substringBefore('@')
}

class Ch4FacebookUser(val accountid: Int): Ch4User3 {
    override val nickname: String
        get() = getFacebookName(accountid)
}

object Ch4CaseInsensitiveFileComparator: Comparator<File> {
    override fun compare(other: File, other2: File): Int {
        return other.path.compareTo(other2.path, ignoreCase = true)
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

    fun init(){
        this::class.java
    }

    open fun emailString(email: String): String{
        return email
    }
}


fun main(args: Array<String>){
    val button = Ch4Button()
    button.showOff()
    button.setFocus(true)
    button.click()

    val rich = Ch4RichButton()
    rich

    val alice = Ch4User2("Alice")
    println(alice.isSubscribed)
    val bob = Ch4User2("Bob")
    println(bob.isSubscribed)
    val carol = Ch4User2("Carol")
    println(carol.isSubscribed)

    println(Ch4CaseInsensitiveFileComparator.compare(File("/home"), File("/Home")))
    val files = listOf(File("/home"), File("/Home"))
    println(files.sortedWith(Ch4CaseInsensitiveFileComparator))

    /*val button = Button4()
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
    println(extender.emailString("mini.chicken.dev"))*/
}
