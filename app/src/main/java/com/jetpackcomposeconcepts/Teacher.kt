package com.jetpackcomposeconcepts

//data classes are simple classes used as data containers and do not encapsulate any additional logic
//Data classes cannot be abstract, open, sealed, or inner.
data class Teacher (var name:String, var age:Int)
{
    //copy()
    //equals()
    //toString()
}

fun main()
{
    var t1 = Teacher("Ron", 33)
    println(t1)

    t1.name = "Shelly"
    println(t1.name)

    var t2 = t1.copy()
    t1.name = "Bill"
    t1.age = 44

    println(t1)
    println(t2)

    println(t1.equals(t2))
    t2.name = "Bill"
    t2.age = 44
    println(t1.equals(t2))

}

