package com.example.sms

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etNumber: EditText = findViewById(R.id.etNumber)
        val etMessage: EditText = findViewById(R.id.etMessage)
        val btSend: Button = findViewById(R.id.btSend)

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS), 10)

        btSend.setOnClickListener {
            val number = etNumber.text.toString()
            val message = etMessage.text.toString()
            val smsmanager: SmsManager
            smsmanager = SmsManager.getDefault()
            smsmanager.sendTextMessage(number, null, message, null, null)
        }

    }
}