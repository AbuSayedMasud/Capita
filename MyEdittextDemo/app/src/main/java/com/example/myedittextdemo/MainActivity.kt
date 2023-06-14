package com.example.myedittextdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(),View.OnClickListener{
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var addButton: Button
    private lateinit var subButton: Button
    private lateinit var textfinal: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText1= findViewById(R.id.text_1)
        editText2= findViewById(R.id.text_2)
        addButton= findViewById(R.id.addButton)
        subButton= findViewById(R.id.subButton)
        textfinal=findViewById(R.id.textview)
        addButton.setOnClickListener(this)
        subButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        try {
            val number1: String = editText1.text.toString()
            val number2: String = editText2.text.toString()
            editText1.setText("")
            editText2.setText("")
            val num1: Double = number1.toDouble()
            val num2: Double = number2.toDouble()
            if(view?.id==R.id.addButton){
                val sum:Double=num1+num2
                textfinal.setText("The sum is "+sum)
            }
            if(view?.id==R.id.subButton){
                val sub:Double=num1-num2
                textfinal.setText("The sub is "+sub)
            }
        }catch (e:Exception){
         val toast:Toast=Toast.makeText(this,"please enter the value",Toast.LENGTH_LONG)
            toast.setGravity(Gravity.BOTTOM,0,0)
            toast.show()
        }

    }
}