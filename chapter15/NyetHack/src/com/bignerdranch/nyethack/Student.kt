package com.bignerdranch.nyethack

class Student(var status: StudentStatue)

sealed class StudentStatue {
    object NotEnrolled : StudentStatue()
    class Active(val courseId: String) : StudentStatue()
    object Graduated: StudentStatue()
}

fun studentMessage(status: StudentStatue): String =
    when (status) {
        is StudentStatue.NotEnrolled -> "Please register your course."
        is StudentStatue.Active -> "You are enrolled in course ${status.courseId}!"
        is StudentStatue.Graduated -> "Congratulations on your graduation."
    }

fun main(args: Array<String>) {
    val student = Student(StudentStatue.Active("Kotlin 101"))
    println(studentMessage(student.status))
}
