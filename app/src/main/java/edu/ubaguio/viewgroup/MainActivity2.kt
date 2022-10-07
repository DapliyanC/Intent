package edu.ubaguio.viewgroup

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //Binding variables with UI elements
        val backBtn: Button = findViewById(R.id.btnBack)
        val sendMail = findViewById<Button>(R.id.btnEmailSend)
        val subj = findViewById<EditText>(R.id.txtSubject)
        val msg = findViewById<EditText>(R.id.txtMessage)
        val recipients = findViewById<EditText>(R.id.txtEmailAddress)
        //val iSend: Intent

        sendMail?.setOnClickListener {
            val iSend=Intent(Intent.ACTION_SENDTO).apply{
                data= Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL,arrayOf(recipients.text.toString()))
                putExtra(Intent.EXTRA_SUBJECT, subj.text.toString())
                putExtra(Intent.EXTRA_TEXT, msg.text.toString())
            }
            try {
                startActivity(iSend)
                Toast.makeText(this, "Content error", Toast.LENGTH_LONG).show()
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Content error", Toast.LENGTH_LONG).show()
            }
        }

        backBtn.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }


    }
}