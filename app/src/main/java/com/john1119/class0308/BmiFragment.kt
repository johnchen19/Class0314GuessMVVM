package com.john1119.class0308

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.john1119.class0308.databinding.FragmentBmiBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BmiFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BmiFragment : Fragment() {
    val TAG=FragmentBmiBinding::class.java.simpleName
    
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentBmiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= FragmentBmiBinding.inflate(layoutInflater)
        Log.d(TAG, "onCreate: ")
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        binding.bCalculate.setOnClickListener{//View不要自己打完因為他會幫忙import
//        println("hahaha")
            var weight=binding.edWeight.text.toString().toFloat()
            var height=binding.edHeight.text.toString().toFloat()
            height=if(height>=2.6) height/100 else height
//        println("bmi is ${weight/(height*height)}")
            var bmi = weight/(height*height)
            bmi=((bmi*100).toInt())/100.0F
            binding.tvBmi.setText(bmi.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_bmi, container, false)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BmiFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BmiFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}