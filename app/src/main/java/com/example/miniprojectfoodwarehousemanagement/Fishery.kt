package com.example.miniprojectfoodwarehousemanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.budiyev.android.codescanner.CodeScannerView
import com.example.miniprojectfoodwarehousemanagement.databinding.ActivityFarmBinding
import com.example.miniprojectfoodwarehousemanagement.databinding.ActivityFisheryBinding
import com.example.miniprojectfoodwarehousemanagement.databinding.ActivityMeatBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Fishery : AppCompatActivity() {
    private lateinit var binding: ActivityFisheryBinding
    private lateinit var database: DatabaseReference
    private lateinit var stocks: Button
    private lateinit var scan : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fishery)
        binding = ActivityFisheryBinding.inflate(layoutInflater )
        setContentView(binding.root)
        stocks = findViewById(R.id.get_stocks)
        stocks.setOnClickListener {
            val intent = Intent(this, GetStocks::class.java)
            startActivity(intent)
        }
        scan = findViewById(R.id.scan)
        scan.setOnClickListener {
            val intent = Intent(this, Qr::class.java)
            startActivity(intent)
        }
        binding.submit.setOnClickListener {
            val itemName = binding.itemName.text.toString()
            val quantity = binding.quantity.text.toString()
            val price = binding.quantity.text.toString()
            val gst = binding.GST.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Items")
            val dairyItems = DairyItems(itemName,quantity,price,gst)
            database.child(itemName).setValue(dairyItems).addOnSuccessListener {
                binding.itemName.text.clear()
                binding.quantity.text.clear()
                binding.price.text.clear()
                binding.GST.text.clear()

                Toast.makeText(this,"successfully Saved", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

