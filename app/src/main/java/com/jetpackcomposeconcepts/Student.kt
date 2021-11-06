package com.jetpackcomposeconcepts

class Student {

    var fname: String
    var lname : String
    var age : Int = 0
    var image : Int = 0

    constructor(fname : String, lname: String, age : Int, imageInt: Int = 1)
    {
        this.fname = fname
        this.lname = lname
        this.age = age

        when(imageInt)
        {
            1-> image = R.drawable.student1
            2-> image = R.drawable.student2
            3-> image = R.drawable.student3
            4-> image = R.drawable.student4
            5-> image = R.drawable.student5
            else-> image = R.drawable.student1
        }
    }
}