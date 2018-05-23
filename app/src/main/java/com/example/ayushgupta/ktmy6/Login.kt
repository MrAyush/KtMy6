package com.example.ayushgupta.ktmy6

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Login:Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v = inflater?.inflate(R.layout.login_screen,container,false)
        return v!!
    }
}
