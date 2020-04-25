package com.example.notekeeper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private  var noteposition=POSITION_NOTE_SET
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val adapterCourse = ArrayAdapter<courseInfo>(this,
            android.R.layout.simple_spinner_item,
            Datamanger.courses.values.toList())
        adapterCourse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
       spinnerCourses.adapter =adapterCourse
        noteposition=intent.getIntExtra(EXTRA_NOTES_POSITION, POSITION_NOTE_SET)
        if(noteposition!=POSITION_NOTE_SET) {
            displayNote()
        }

    }

    private fun displayNote() {
        val note=Datamanger.notes[noteposition]
        textNoteTitle.setText(note.title)
        textNoteText.setText(note.text)

        var courseposition=Datamanger.courses.values.toString().indexOf(note.course)//[{name,title},{name,title},{name,title},{name,title}]
        spinnerCourses.setSelection(courseposition)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
