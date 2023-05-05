package com.example.android_kt_sqlite_ormlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_kt_sqlite_ormlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            if (binding.etUserName.text.isNotEmpty()){
                val nametoDb = UserName()
                nametoDb.setName(binding.etUserName.text.toString())
                UserNameRepository(this).addName(nametoDb)
                binding.etUserName.text.clear()
                binding.tvInfo.text = "Nombre ingresado"
            }else binding.tvInfo.text = "Ingrese un nombre"
        }


        binding.btnShow.setOnClickListener {
            val namesDb = UserNameRepository(this).getNames()
            if(namesDb.isNotEmpty()){
                val listNames = mutableListOf<String>()
                namesDb.forEach{
                    listNames.add(it.getName().toString())
                }
                binding.tvInfo.text = listNames.toString()
            }else{
                binding.tvInfo.text = "DB vacía"
            }
        }

        binding.btnDelete.setOnClickListener {
            val namesOnDb = UserNameRepository(this).getNames()
            if (namesOnDb.isNotEmpty()){
                namesOnDb.forEach {
                    UserNameRepository(this).deleteAll(it.getId()!!)
                }
                binding.tvInfo.text = "DB borrada"
            }else{
                binding.tvInfo.text = "Sin datos que borrar"
            }
        }
    }
}

