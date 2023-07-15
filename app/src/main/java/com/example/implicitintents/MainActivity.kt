package com.example.implicitintents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.implicitintents.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun openWebsite(view: View) {
        // Get the URL text, parse the URI and create the intent.
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(binding.websiteEdittext.text.toString()))
        // Start activity.
        startActivity(intent)
    }

    fun openLocation(view: View) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact. Parse the location and create the intent.
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=${binding.locationEdittext.text}"))

        // Start activity.
        startActivity(intent)
    }

    fun shareText(view: View) {
        // Get the string value, define the mime type of the text to share and create the intent.
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, binding.shareEdittext.text.toString())

        // Start activity.
        startActivity(intent)
    }
}