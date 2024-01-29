package com.example.intentpassingdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentpassingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    public lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //apply logic to the Submit Button
        binding.btnSubmit.setOnClickListener {
            // passing the data in the edit text
            val Name = binding.etName.text.toString()
            val Country = binding.etCountry.text.toString()
            // converting the number in string to int
            val Age = binding.etAge.text.toString().toInt()

            val person = Person(Name,Country,Age)

            Intent(this,SecondActivity::class.java).also {
                it.putExtra("EXTRA PERSON",person)
//                it.putExtra("EXTRA NAME",Name)
//                it.putExtra("EXTRA COUNTRY",Country)
//                it.putExtra("EXTRA AGE",Age)
                startActivity(it)
            }
        }
    }
}