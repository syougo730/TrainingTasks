package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.ui.AppBarConfiguration
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println(" -- onCreate -- ")

        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            //Fragmentを作成します
            val fragment = FirstFragment()
            // Fragmentの追加や削除といった変更を行う際は、Transactionを利用します
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.container, fragment)
            // 最後にcommitを使用することで変更を反映します
            transaction.commit()
        }

    }
    override fun onPause() {
        super.onPause()
        println("-- onPause --")
    }

    override fun onResume() {
        super.onResume()
        println("-- onResume --")
    }



}