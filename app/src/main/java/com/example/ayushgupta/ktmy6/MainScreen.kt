package com.example.ayushgupta.ktmy6

import android.app.Fragment
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainScreen:Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater?.inflate(R.layout.main_screen,container,false)
        val btn1: Button = v!!.findViewById(R.id.btn1)
        val btn2: Button = v.findViewById(R.id.btn2)
        val et1:EditText = v.findViewById(R.id.et1)
        val et2:EditText = v.findViewById(R.id.et2)
        val fragment = fragmentManager.beginTransaction()
        btn1.setOnClickListener{
            val spf:SharedPreferences = activity.getSharedPreferences("MyList",Context.MODE_PRIVATE)
            val username = spf.getString("username","!--noValue--!")
            val pass = spf.getString("pass","!--noValue--!")
            if (et1.text.toString() == username && et2.text.toString() == pass) {
                fragment.remove(Fragment())
                Toast.makeText(activity,"Login successful",Toast.LENGTH_SHORT).show()
                fragment.replace(R.id.fl1, Login(username))
                fragment.addToBackStack("true")
                fragment.commit()
            }
            else
                Toast.makeText(activity,"Can't find the user",Toast.LENGTH_SHORT).show()
        }
        btn2.setOnClickListener {
            fragment.remove(Fragment())
            fragment.replace(R.id.fl1,SignUp())
            fragment.addToBackStack("true")
            fragment.commit()
        }
        return v
    }
}