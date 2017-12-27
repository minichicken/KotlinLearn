package com.github.minichicken

fun main(args: Array<String>){
    val (result, status, some,fuck: Int, shit: Int ) = functions(2, 4 ,3 ,5, 5)
    println("$result $status $some $fuck $shit")

    val soeemed = Triple(2,3,4)
    val soem = arrayOf("ff", "ff" , "fds")
    println(soem[2])
}

data class Result(val result: Int, val status: Int, val some: Int, val fuck: Int, val shit: Int)

fun functions(result: Int, status: Int, some: Int, fuck: Int, shit: Int): Result {
    return Result(result, status, some, fuck, shit)
}