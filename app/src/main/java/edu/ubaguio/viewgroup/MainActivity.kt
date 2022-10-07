package edu.ubaguio.viewgroup

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webBtn: Button = findViewById(R.id.btnGoogle)
        val mailBtn: Button = findViewById(R.id.btnEmail)
        val toastBtn: Button = findViewById(R.id.btnToast)
        val nxtBtn: Button = findViewById(R.id.btnNext)
        val emailBtn: Button = findViewById(R.id.btnEmail)
        val cameraBtn: Button = findViewById(R.id.btnEventScheduler)
        val dialerBtn: Button = findViewById(R.id.btnDialer)
        val schedulerBtn: Button = findViewById(R.id.btnEventScheduler)

        //explicit intent -> launch or start an activity
        nxtBtn.setOnClickListener {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(i)
        }
        //implicit intent -> open URL
        webBtn.setOnClickListener {
            val strURL = "https://www.ubaguio.edu"
            val iBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(strURL))
            startActivity(iBrowser)
        }
        val txtMsg="Hello there"
        val errMsg="No message found."
        val iEmail = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, txtMsg)
            type = "type/plain"
            //open email
        }
        emailBtn.setOnClickListener {
            try {
                startActivity(iEmail)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this@MainActivity, errMsg, Toast.LENGTH_LONG).show()
            }

        }
        //open device dialer
        dialerBtn.setOnClickListener {
            val iDialer = Intent(Intent.ACTION_DIAL)
            startActivity(iDialer)
        }
        toastBtn.setOnClickListener {
            Toast.makeText(this, "Goodbye", Toast.LENGTH_LONG).show()
        }

        schedulerBtn.setOnClickListener {
            val i = Intent(this, EventScheduler::class.java)
            startActivity(i)
        }


    }


}
