package com.example.tvproject

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.tvproject.com.example.tvproject.MyEpgFragment2
import com.jakewharton.threetenabp.AndroidThreeTen

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the 310 backport lib. Usually you do this in your application object
        AndroidThreeTen.init(this)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, EpgFragment())
            .commit()
    }
}