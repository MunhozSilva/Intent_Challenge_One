package com.example.intentchallengeone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.makeText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //look for the views ID to track them
        val textEdited = findViewById<EditText>(R.id.message_text)
        val sendButton = findViewById<Button>(R.id.send_button)

        //listen to when the button is gonna be pressed
        sendButton.setOnClickListener {
            //just showing a toast to practice
            makeText(this, "Sending", Toast.LENGTH_SHORT).show()

            //EditText to String
            val textToSend = textEdited.text.toString()

            //creating the intent to share the message
            //obs: .apply means we are using a "bundle" indirectly
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, textToSend)
                type = "text/plain"
            }

            //intent to send the message
            val sendingMessageIntent = Intent.createChooser(intent, null)
            startActivity(sendingMessageIntent)
        }
    }
}