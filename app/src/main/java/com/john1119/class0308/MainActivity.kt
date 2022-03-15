package com.john1119.class0308
//The Controller,display
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.john1119.class0308.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {//一部份放onCreateView，另一部份放onViewCreated
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragment()
    }

    private fun initFragment() {
        val guess1to10Fragment=BlankFragment()
        val transaction=supportFragmentManager.beginTransaction()
        transaction.add(R.id.main_container,guess1to10Fragment)
        transaction.commit()

        //kotlin way上等於下
//        supportFragmentManager.beginTransaction().let{
//            it.add(R.id.main_container,guess1to10Fragment).commit()
//        }//讓他做什麼，裡面要用it
        supportFragmentManager.beginTransaction().run{
            add(R.id.main_container,guess1to10Fragment).commit()
        }//單純做事
//        val t = supportFragmentManager.beginTransaction().apply{
//            add(R.id.main_container,guess1to10Fragment).commit()
//        }//做完事情還要存起來

    }


}