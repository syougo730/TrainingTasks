package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null //バッキングプロパティ 参照するときに参照するものはnullではないことを強制するためのもの

    private var buttonFlg = 0
    private val buttonTexts = arrayOf("ほげ","ふが")

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println(" -- onCreate - fragment -- ")

        if(savedInstanceState != null){
            buttonFlg = savedInstanceState.getInt("buttonFlg")
        }
        println(" buttonFlg -> $buttonFlg ")

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        println("-- onCreateView --")

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        println("binding.root -> ${binding.root}")

        val button = binding.buttonFirst
        button.text = buttonTexts[buttonFlg]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println("-- onViewCreated --")
        println("buttonFlg  -> $buttonFlg")

        binding.buttonFirst.setOnClickListener {
            when(buttonFlg){
                0 -> buttonFlg = 1
                1 -> buttonFlg = 0
            }
            val button = binding.buttonFirst
            button.text = buttonTexts[buttonFlg]
            println(" buttonFlg -> $buttonFlg ")
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        println(" -- onDestroyView - fragment -- ")
        _binding = null
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        println("-- onSaveInstanceState --")
        outState.putInt("buttonFlg", buttonFlg)
        println(" buttonFlag(onSIS) -> $buttonFlg")
    }
}