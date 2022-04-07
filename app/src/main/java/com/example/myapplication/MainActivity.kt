package com.example.myapplication

import android.app.AlertDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel : CheckedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        checkShared()
        // "DataStore"という名前でインスタンスを生成
        val dataStore = getSharedPreferences("DataStore", MODE_PRIVATE)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        viewModel =  ViewModelProvider(this).get(CheckedViewModel::class.java)

        val checkBox1 = findViewById<CheckBox>(R.id.checkbox_1)
        val checkBox2 = findViewById<CheckBox>(R.id.checkbox_2)

        val check1: Boolean = dataStore.getBoolean("Data_${checkBox1.id}", false)
        val check2: Boolean = dataStore.getBoolean("Data_${checkBox2.id}", false)
        println("onCreate->dataBoolean $check1")//debug
        println("checkbox1 = $checkBox1")
        if(check1) checkBox1.isChecked = check1
        if(check2) checkBox2.isChecked = check2

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun onCheckboxClicked(view: View) {
        //シェアードインスタンスの準備
        val data = getSharedPreferences("DataStore", MODE_PRIVATE)
        val editor = data.edit()

        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                //1つ目のチェックボックス押下時
                R.id.checkbox_1 -> {
                    if (checked) {
                        // FragmentではActivityを取得して生成
                        AlertDialog.Builder(this)
                        .setTitle("タイトル")
                        .setMessage("メッセージ")
                        .show()
                    }

                }
                //2つめのチェックボックス押下時
                R.id.checkbox_2 -> {
                    Toast.makeText( //トースト表示
                        this,
                        view.isChecked.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            // シェアードインスタンス　保存
            editor.putBoolean("Data_${view.id}", checked)
            editor.apply()
        }
    }

    //シェアードインスタンスに値が入っているか確認
    fun checkShared(){
        val preference = getSharedPreferences("DataStore", MODE_PRIVATE)

        val map = preference.all
        println(" map = $map ")
        for ((key, value1) in map) {
            val value = value1!!
            val msg = String.format("%s = %s", key, value)
            println("LogSample $msg ")
        }
    }

}