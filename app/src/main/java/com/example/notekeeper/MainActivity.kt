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
        noteposition=savedInstanceState?.getInt(NOTES_POSITION, POSITION_NOTE_SET)?:
            intent.getIntExtra(NOTES_POSITION, POSITION_NOTE_SET)
        if(noteposition!=POSITION_NOTE_SET) {
            displayNote()
        }
        else
        {
            Datamanger.notes.add(NoteInfo(course))
            noteposition=Datamanger.notes.lastIndex
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NOTES_POSITION,noteposition)
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
            R.id.action_next->{
                moveNext()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveNext() {
        ++noteposition
        displayNote()
        invalidateOptionsMenu()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if(noteposition>=Datamanger.notes.lastIndex)
        {
            val menuItem=menu?.findItem(R.id.action_next)
            if(menuItem!=null)
            {
                menuItem.icon = getDrawable(R.drawable.ic_block_black_24dp)
                menuItem.isEnabled = false

            }
        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onPause() {
        super.onPause()
        saveNote()
    }

    private fun saveNote() {
        val note= Datamanger.notes [noteposition]
        note.title=textNoteTitle.text.toString()
        note.text=textNoteText.text.toString()
        note.course =  (spinnerCourses.selectedItem  as courseInfo).toString()
    }
}
