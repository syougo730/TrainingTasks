package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    var buttonFlg = 1
    val buttonTexts = arrayOf("ほげ","ふが")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.fragment_first,
            container, false
        )

        var button = view.findViewById<Button>(R.id.button_first)
        button.setOnClickListener {
            when(buttonFlg){
                0 -> buttonFlg = 1
                1 -> buttonFlg = 0
            }
            button.text = buttonTexts[buttonFlg]
        }

        return view
    }

}