package kotlininaction.chapter3


val list = listOf(1,2,3)
fun <T> joinToString(collection: Collection<T>, separator: String, prefix: String, postfix: String): String{
    val result = StringBuilder(prefix)
    for((index, element) in collection.withIndex()){
        result.append(element)
        if (index < collection.size -1) {
            result.append(separator)
        }
    }
    result.append(postfix)
    return result.toString()
}



fun String.lastChar(): Char = get(length - 1)

open class View {
    open fun click() {
        println("View Clicked!")
    }
}

class Button: View(){
    override fun click() {
        //super.click()
        println("Button Clicked!")
    }
}

var String.lastChar: Char
    get() = get(length -1)
    set(value: Char) {
        println(this.plus(value))
    }


var StringBuilder.lastChar: Char
    get() = get(length -1)
    set(value) {
        this.setCharAt(this.length -1, value)
    }

fun main(args: Array<String>){
    val list = listOf("args: ", *args)
    println(list)
    //println(joinToString(list, ";", "(", ")"))
    //println(joinToString(list, separator = ";", prefix = "(", postfix = ")"))
    //println("hello world".lastChar())
    println("abcde".substring(1))
    val view: View = Button()
    view.click()
    val temp: String = "hello"
    temp.lastChar = 'e'
    println(temp)
    val text = StringBuilder("Dd")
    text.lastChar = '2'
    println(text.lastChar)
    println("hello hell?".lastChar)
}
