package com.example.imageview


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var image1:ImageView
    private lateinit var image2:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        image1 =findViewById(R.id.image_1)
        image2=findViewById(R.id.image_2)
        image1.setOnClickListener(this)
        image2.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if(v?.id==R.id.image_1){
            val toast:Toast= Toast.makeText(this,"click 1",Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP,40,40)
            toast.show()

        }
        if(v?.id==R.id.image_2){
            val toast:Toast= Toast.makeText(this,"click 2",Toast.LENGTH_LONG)
            toast.setGravity(Gravity.BOTTOM,100,100)
            toast.show()
        }
    }
}