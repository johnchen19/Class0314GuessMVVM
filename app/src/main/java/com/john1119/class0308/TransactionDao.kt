package com.john1119.class0308

import androidx.room.*

@Dao
interface TransactionDao {
    @Query("select * from `Transaction` where id = :id")//:id是指使用getById時傳入的id
    fun getById(id:Int):Transaction
    @Query("select * from `Transaction` ORDER BY createAt DESC")
    fun getAll():List<Transaction>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tran:Transaction)
    @Delete
    fun delete(tran:Transaction)
    @Update
    fun update(tran:Transaction)//如果replace那insert就能做掉不用update
}