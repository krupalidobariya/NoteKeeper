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
        var course = courseInfo("android_intents","Android Programming with Intents")
        courses.set(course.CourseId,course)

        course = courseInfo(CourseId = "android_async", Title = "Android Async Programming and services")
        courses.set(course.CourseId,course)

        course = courseInfo(CourseId = "Java Fundamental:The Java Language", Title = "Java_lang")
        courses.set(course.CourseId,course)

        course = courseInfo(CourseId = "java_core", Title = "Java Fundamentals: The core Platform")
        courses.set(course.CourseId,course)
    }

    private fun initialNotes()
    {
       var note= NoteInfo("Android Programming with Intents","Dynamic intents resoulation","wow,intent allow component to be resolved at runtime")
        notes.add(note)

        note= NoteInfo(course ="Android Programming with Intents", title ="Delegating intents", text ="pending intents are powerful:they delegate much more than just a component invocation")
        notes.add(note)

        note= NoteInfo(course ="android_async", title ="services default threads", text ="Did you know that by default Android services will tie up the ui therad?")
        notes.add(note)

        note= NoteInfo(course ="android_async", title ="long running Operations", text ="Foreground services can be tie to a notification icon")
        notes.add(note)

        note= NoteInfo(course ="Java Fundamental:The Java Language", title ="parameters", text ="Leverage variable-length parameter lists ")
        notes.add(note)

        note= NoteInfo(course ="Java Fundamental:The Java Language", title ="Anonymous classes", text ="Anonymous classes simplify implementing one-use type")
        notes.add(note)

        note= NoteInfo(course ="java_core", title ="Complier options", text ="The -jar option isn't compatiable with the -cp option")
        notes.add(note)

        note= NoteInfo(course ="java_core", title ="serialization", text ="Remember to include ServicesVersionUID to assure version compatibilty")
        notes.add(note)

    }
}
