package com.john1119.class0308
//model類別
//邏輯與data//MVC風格
class PickSecret() {
    //原始
//    var secret = (1..10).random()
//    var counter = 0
//    var end=false
//    fun reset(){
//        secret=(1..10).random()
//        counter=0
//        end=false
//    }
    //修改成
    enum class GameState{
        INIT,BIGGER,SMALLER,END,BINGO
    }
    var secret:Int =0
    var counter = 0
    var end=false
    init {
        reset()
    }
    fun reset(){
        secret=(1..10).random()
        counter=0
        end=false
    }

    fun guess(number:Int):GameState{
        counter++
        val message = if(number>secret) GameState.SMALLER
        else if(number<secret) GameState.BIGGER
        else {
            end = true
            GameState.BINGO
        }
        return message
    }
}