package com.example.notekeeper

class courseInfo(val CourseId:String , val Title : String) {
    override fun toString(): String {
        return Title
    }
}

class NoteInfo(var course:courseInfo , var title:String , var text:String)