package com.github.minichicken

interface Clickable{
    fun click()
    fun showOff() = println("this is clickable!")
    fun setFocus(b: Boolean)
}

interface Focusable{
    fun click()
    fun showOff() = println("this is focusable!")
    fun setFocus(b: Boolean)
}

class Button: Clickable, Focusable {
    override fun setFocus(b: Boolean) {
        if(b){
            println("I got focus")
        } else {
            println("I missed focus")
        }
    }

    override fun click() {
        println("clicked!")
    }

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main(args: Array<String>){
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}
