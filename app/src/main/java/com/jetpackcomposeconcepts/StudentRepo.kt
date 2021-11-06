package com.jetpackcomposeconcepts

class StudentRepo {
    var students : ArrayList<Student>
    constructor()
    {
        students = ArrayList()
        students.add(Student("Marc", "Lab", 33, 1))
        students.add(Student("Mike", "Lab", 66, 2))
        students.add(Student("Bill", "Lab", 32, 3))
        students.add(Student("Tony", "Lab", 22, 4))
        students.add(Student("Eli", "Lab", 41, 5))
        students.add(Student("George", "Lab", 11, 1))
        students.add(Student("Mary", "Lab", 77, 2))
        students.add(Student("Michelle", "Lab", 66, 3))
        students.add(Student("Tanisha", "Lab", 47, 4))
        students.add(Student("Elizabeth", "Lab", 41, 5))
        students.add(Student("Alio", "Lab", 66, 1))
        students.add(Student("Thom", "Lab", 77, 2))
        students.add(Student("Zack", "Lab", 88, 3))
        students.add(Student("Kelly", "Lab", 99, 4))
        students.add(Student("Tami", "Lab", 33, 5))
    }
}