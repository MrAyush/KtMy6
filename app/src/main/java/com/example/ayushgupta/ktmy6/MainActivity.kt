package com.example.ayushgupta.ktmy6

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = fragmentManager.beginTransaction()
        fragment.add(R.id.fl1,MainScreen())
        fragment.commit()
    }
}
