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
    val viewModel by viewModels<GuessViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.counter.observe(this) {
            binding.tvCounter.setText(it.toString())
        }
        viewModel.gameState.observe(this) { state ->
            val message = when (state) {
                GuessViewModel.GameState.BIGGER -> getString(R.string.bigger)
                GuessViewModel.GameState.SMALLER -> getString(R.string.smaller)
                GuessViewModel.GameState.BINGO -> getString(R.string.bingo)
                GuessViewModel.GameState.INIT -> "START"
                else -> getString(R.string.something_go_wrong)
            }
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_title))//快速鍵alt+enter
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok)) { d, w ->
                    if (state == GuessViewModel.GameState.BINGO) {
                        viewModel.reset()
                    }
                }
                .show()
        }
    }

    fun guess(view: View) {
        Log.d(TAG, "Testing")
        var number = binding.edNumber.text.toString().toInt()
        viewModel.guess(number)
    }

}