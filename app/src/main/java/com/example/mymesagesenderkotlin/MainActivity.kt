package com.example.mymesagesenderkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val MESSAGE = "message"
    private val CUSTOM_ACTION = "custom_action"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View){
        if (checkIfEmpty()) {
            prepareAndSend()
        } else {
            Toast.makeText(this, "Message field must be filled", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkIfEmpty() = messageSendField.text.isNotEmpty()

    private fun prepareAndSend(){
        val intent = Intent()
        intent.action = CUSTOM_ACTION
        intent.addFlags(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES)
        intent.putExtra(MESSAGE, messageSendField.text.toString())
        sendBroadcast(intent)
    }
}
