package com.example.ayushgupta.ktmy6

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun ClickEvent(v: View){
        var fragment = fragmentManager.beginTransaction()
        when(v.id){
            R.id.btn1->fragment.replace(R.id.fl1,Login())
        }
        fragment.addToBackStack("true")
        fragment.commit()
    }
}
