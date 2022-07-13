package com.example.miniprojectfoodwarehousemanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var fish:Button
    private lateinit var farm:Button
    private lateinit var meat:Button
    private lateinit var dairy:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fish = findViewById(R.id.fish)
        farm = findViewById(R.id.farm)
        meat = findViewById(R.id.meat)
        dairy = findViewById(R.id.dairy)
        fish.setOnClickListener {
            val intent = Intent(this, Fishery::class.java)
            startActivity(intent)
        }
        farm.setOnClickListener {
            val intent = Intent(this, Farm::class.java)
            startActivity(intent)
        }
        meat.setOnClickListener {
            val intent = Intent(this, Meat::class.java)
            startActivity(intent)
        }
        dairy.setOnClickListener {
            val intent = Intent(this, Dairy::class.java)
            startActivity(intent)
        }
    }
}