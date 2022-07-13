package com.example.miniprojectfoodwarehousemanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.miniprojectfoodwarehousemanagement.databinding.ActivityGetstocksBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class GetStocks : AppCompatActivity() {
    private lateinit var binding : ActivityGetstocksBinding
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetstocksBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.getData.setOnClickListener {

            val itemName : String = binding.itemName.text.toString()
            if  (itemName.isNotEmpty()){

                readData(itemName)

            }else{

                Toast.makeText(this,"PLease enter the Username",Toast.LENGTH_SHORT).show()

            }

        }

    }

            private fun readData(itemName: String) {

                database = FirebaseDatabase.getInstance().getReference("Items")
                database.child(itemName).get().addOnSuccessListener {

                    if (it.exists()){

                        val itemName = it.child("itemName").value
                        val price = it.child("price").value
                        val quantity = it.child("quantity").value
                        Toast.makeText(this,"Successfuly Read",Toast.LENGTH_SHORT).show()
                        binding.itemName.text.clear()
                        binding.item1.text = itemName.toString()
                        binding.price1.text = price.toString()
                        binding.price.text = quantity.toString()

                    }else{

                        Toast.makeText(this,"Item Doesn't Exist",Toast.LENGTH_SHORT).show()


                    }

                }.addOnFailureListener{

                    Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


                }



            }
        }