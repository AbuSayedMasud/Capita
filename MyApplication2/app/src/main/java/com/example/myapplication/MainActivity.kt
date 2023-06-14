package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.rotate_open)
    }
    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.rotate_close)
    }
    private val fromBottom: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.from_bottom)
    }
    private val toBottom: Animation by lazy {
        AnimationUtils.loadAnimation(this, R.anim.to_bottom)
    }
    private var clicked =false
    private lateinit var add_btn: FloatingActionButton
    private lateinit var filter: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_btn=findViewById(R.id.add)
        filter=findViewById(R.id.filter)
        add_btn.setOnClickListener {
            onAddButtonClick()
        }
        filter.setOnClickListener {
            Toast.makeText(this@MainActivity, "hello", Toast.LENGTH_SHORT).show()
        }


    }
    private fun onAddButtonClick(){
        setVisiblity(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    private fun setAnimation(click: Boolean) {
     if(!click){
         filter.startAnimation(fromBottom)
         add_btn.startAnimation(rotateOpen)
     }
        else{
         filter.startAnimation(toBottom)
         add_btn.startAnimation(rotateClose)
     }
    }

    private fun setVisiblity(click: Boolean) {
        if(!click){
            filter.visibility= View.VISIBLE
            filter.startAnimation(rotateOpen)
        }
        else
        {
            filter.visibility=View.INVISIBLE
        }
    }
    private fun setClickable(click: Boolean){
        filter.isClickable = !click
    }
}