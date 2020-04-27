package com.example.notekeeper

data class courseInfo(val CourseId: String, val Title: String) {
    override fun toString(): String {
        return Title
    }
}

data class NoteInfo(var course: String?, var title:String?=null, var text:String?=null){

}