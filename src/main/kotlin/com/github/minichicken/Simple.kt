package com.github.minichicken

import java.util.*

/**
 *
 */

data class Persion(val name: String?, val age: Int?)

fun main(args: Array<String>) {
    val rand = Random()
    val randomValue = generateSequence { rand.nextInt(10) - 5 }.take(10).toList()

    randomValue.sortedBy { it > 4 }
    println(randomValue)
    val people = listOf(
            Persion("hello", 13),
            Persion("hello1", 11),
            Persion("hello2", 12),
            Persion(null, null),
            Persion("hello", 15),
            Persion("hello5", 155)
    )


    println(people.elementAt(3))
    println(people)
    println(people.sortedBy { it.name })
    println(people.sortedWith(compareBy(Persion::name, Persion::age)))
    println(people.sortedWith(compareBy ({ it.name }, {it.age})))
    println(people.sortedWith(compareBy<Persion>{it.age}.thenByDescending { it.name }))
    val word  = "hello".toCharArray().toList()
    val word2 = "Help".toCharArray().toList()
    println(word.distinct())
    println(word.intersect(word2))
    println(word.union(word2))
    println(word.subtract(word2).distinct())
    print(word subtract word2) /// infix
    println("distict by name " + people.sortedByDescending { it.age }.distinctBy { it.name })
    println()
}