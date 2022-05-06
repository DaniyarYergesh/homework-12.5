package com.example.myapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity(R.layout.new_activity){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val camera: TextView = findViewById(R.id.string5)
        camera.setOnClickListener { dispatchTakePictureIntent() }


        val call: TextView = findViewById(R.id.string4)
        call.setOnClickListener {
            dialPhoneNumber()
        }


        val mail: TextView = findViewById(R.id.string3)
        mail.setOnClickListener {composeEmail()}


        val share: TextView = findViewById(R.id.string2)
        share.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "*/*"
            startActivity(Intent.createChooser(sharingIntent, "Share using"))
        }
    }

    val REQUEST_IMAGE_CAPTURE = 1

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }

    fun dialPhoneNumber() {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:${87}")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun composeEmail(){
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "*/*"
            putExtra(Intent.EXTRA_EMAIL, "")
            putExtra(Intent.EXTRA_SUBJECT, "")
            putExtra(Intent.EXTRA_STREAM, "")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }


}

