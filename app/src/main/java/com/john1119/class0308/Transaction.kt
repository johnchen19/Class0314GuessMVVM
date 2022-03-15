package com.john1119.class0308

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
class Transaction(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val account: String,
    @ColumnInfo(name="createAt")
    val date: String,//改名
    val amount: Int,
    val type: Int
) {

}