package com.example.notekeeper

object Datamanger {
    val courses = HashMap<String,courseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourse()
        initialNotes()
    }

    private fun initializeCourse()
    {
        var course = courseInfo("Android","Android Programming with Kotlin")
        courses.set(course.CourseId,course)

        course = courseInfo(CourseId = "Android_async",Title = "Android Async Programming and services")
        courses.set(course.CourseId,course)

        course = courseInfo(CourseId = "Java Fundamental",Title = "Java_Lang")
        courses.set(course.CourseId,course)

        course = courseInfo(CourseId = "Java_core",Title = "JAVA CORE:The Fundamental concepts")
        courses.set(course.CourseId,course)
    }

    private fun initialNotes()
    {

    }
}