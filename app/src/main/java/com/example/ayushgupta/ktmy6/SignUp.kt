package com.example.ayushgupta.ktmy6

import android.app.Fragment
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class SignUp:Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater?.inflate(R.layout.signup_screen,container,false)
        val btn1: Button = view!!.findViewById(R.id.Sbtn1)
        val spf:SharedPreferences = activity.getSharedPreferences("MyList",Context.MODE_PRIVATE)
        val editor = spf.edit()
        val set1:EditText = view.findViewById(R.id.set1)
        val set2:EditText = view.findViewById(R.id.set2)
        val set3:EditText = view.findViewById(R.id.set3)
        val spinner:Spinner = view.findViewById(R.id.gender)
        var gender:String? = null
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) { }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position > 0){
                    gender = spinner.selectedItem.toString()
                }
                if (position == 0){
                    gender = null
                }
            }

        }
        btn1.setOnClickListener {
            when {
                set1.text.toString() == "" -> Toast.makeText(activity,"Username can't be empty",Toast.LENGTH_SHORT).show()
                set2.text.toString() == "" || set3.text.toString() == ""-> Toast.makeText(activity,"Password can't be empty",Toast.LENGTH_SHORT).show()
                set2.text.toString() != set3.text.toString() -> Toast.makeText(activity,"Password incorrect",Toast.LENGTH_SHORT).show()
                gender == null -> Toast.makeText(activity,"Select your gender",Toast.LENGTH_SHORT).show()
                else -> {
                    Toast.makeText(activity,"Credential's saved",Toast.LENGTH_SHORT).show()
                    editor.putString("username",set1.text.toString())
                    editor.putString("pass",set2.text.toString())
                    editor.putString("gender",gender)
                    val fragment = fragmentManager.beginTransaction()
                    fragment.remove(Fragment())
                    fragment.replace(R.id.fl1,MainScreen())
                    fragment.commit()
                    Toast.makeText(activity,"Please login!!",Toast.LENGTH_SHORT).show()
                }
            }
            editor.apply()
        }
        return view
    }
}
