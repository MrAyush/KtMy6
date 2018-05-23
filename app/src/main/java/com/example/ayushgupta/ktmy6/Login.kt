package com.example.ayushgupta.ktmy6

import android.annotation.SuppressLint
import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

@SuppressLint("ValidFragment")
class Login(user: String) : Fragment() {
    private var username:String? = user
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater?.inflate(R.layout.login_screen,container,false)
        val tv1:TextView = v!!.findViewById(R.id.Ltv1)
        tv1.text = username
        return v
    }
}
