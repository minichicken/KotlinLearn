package kotlininaction.chapter5

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>){
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people){
        if (person.age > maxAge){
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

val sum = {x: Int, y: Int -> x + y}

fun main(args: Array<String>){
    val people = listOf(Person("jaeho", 19), Person("younghun", 18))
    findTheOldest(people)
    println(sum(1, 2))
}