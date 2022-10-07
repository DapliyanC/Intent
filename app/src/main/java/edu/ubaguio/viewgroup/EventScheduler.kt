package edu.ubaguio.viewgroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class EventScheduler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_scheduler)

        val intent = Intent(Intent.ACTION_EDIT)
        val title = findViewById<EditText>(R.id.txtTitle)
        val description = findViewById<EditText>(R.id.txtDescription)
        val eventStart = findViewById<EditText>(R.id.txtStart)
        val eventEnd = findViewById<EditText>(R.id.txtEnd)
        intent.type = "vnd.android.cursor.item/event"
        intent.putExtra("title", "Some title")
        intent.putExtra("description", "Some description")
        intent.putExtra("beginTime", eventStart.text.toString())
        intent.putExtra("endTime", eventEnd.text.toString())

        startActivity(intent)
    }

}