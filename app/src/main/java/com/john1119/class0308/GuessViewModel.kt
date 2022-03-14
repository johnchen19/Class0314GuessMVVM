package com.john1119.class0308

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuessViewModel : ViewModel() {
    private var secret = 0
    val counter = MutableLiveData<Int>()

    enum class GameState {
        INIT, BIGGER, SMALLER, END, BINGO
    }

    val gameState = MutableLiveData<GameState>()

    init {
        gameState.value = GameState.INIT
        secret = (0..10).random()
        println("secret=$secret")
        counter.value = 0
    }

    fun guess(num: Int) {
        counter.value = counter.value?.plus(1)
        gameState.value = if (num > secret) GameState.SMALLER
        else if (num < secret) GameState.BIGGER
        else {
            GameState.BINGO
        }
    }

    fun reset() {
        counter.value = 0
        secret = (0..10).random()
    }
}