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
       var note= NoteInfo("Android Programming with Kotlin","Dynamic Intent Resoulation","wow!Intent allow component to be resolved at runtime")
        notes.add(note)

        note= NoteInfo(course ="Android Async Programming and services", title ="services default therad", text ="Android service can tie with ui")
        notes.add(note)

        note= NoteInfo(course ="Android Async Programming and services", title ="Long running Operation", text ="Forground sevices can be tied to a notification icon")
        notes.add(note)

        note= NoteInfo(course ="Java Fundamental", title ="parameter", text ="variable-lists")
        notes.add(note)

        note= NoteInfo(course ="Android Async Programming and services", title ="Annoynemes class", text ="simplyfiles implementing one-use type")
        notes.add(note)

        note= NoteInfo(course ="Java_core", title ="complier option", text ="the-jar option isnt compatible with the-cp option")
        notes.add(note)

        note= NoteInfo(course ="Java_core", title ="seralization", text ="assure version compability")
        notes.add(note)

    }
}
