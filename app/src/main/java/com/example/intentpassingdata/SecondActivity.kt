package com.example.intentpassingdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentpassingdata.databinding.ActivitySecondBinding
import java.util.jar.Attributes

class SecondActivity : AppCompatActivity() {
    public lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // passing the extras in the edit text from the activity passing data
//        val Name = intent.getStringExtra("EXTRA NAME")
//        val Country = intent.getStringExtra("EXTRA COUNTRY")
//        val Age = intent.getIntExtra("EXTRA AGE",0)
        val person = intent.getSerializableExtra("EXTRA PERSON") as Person
//        val personString = "Name is ${Attributes.Name} , from $Country, age is $Age years old"

        // pass the data to the textView
        binding.tvPerson.text = person.toString()

        // back button returns to the previous activity
        binding.btnBack.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}