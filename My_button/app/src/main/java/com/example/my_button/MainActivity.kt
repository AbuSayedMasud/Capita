package com.example.my_button

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var buttonfind=findViewById<Button>(R.id.login_id)

        var logout=findViewById<Button>(R.id.logout_id)
        text=findViewById<TextView>(R.id.textview_id)

//        buttonfind.setOnClickListener(this)
//        logout.setOnClickListener(this)


    }
    public fun showData(view: View) {
        if (view.id==R.id.login_id){
//            text?.setText("log in button")
//            val toast: Toast = Toast.makeText(this, "login is click", Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.BOTTOM,0,0)
//            toast.show()
            Log.d("print","ghdfggggggggggggggff")
        }
        if(view.id==R.id.logout_id){
//            val toast: Toast = Toast.makeText(this, "logout is click", Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.BOTTOM,0,0)
//            toast.show()
//            text?.setText("logout button")
            Log.d("pri","hfdsdddddddddddddddd")
        }

    }

//    override fun onClick(view: View?) {
//        if (view?.id==R.id.login_id) {
//
//            text?.setText("log in button")}
//
//
//        if (view?.id==R.id.logout_id) {
//
//            text?.setText("log out button")}
//    }
}




