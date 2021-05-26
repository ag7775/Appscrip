package com.shivam.kotlin.appscriptask.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.shivam.kotlin.appscriptask.modal.Summary

@Dao
interface SummaryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSummary(summary: Summary)

    @Query("Select * from summary_table order by startDate")
    fun getAllSummary() : LiveData<List<Summary>>

    @Update
    suspend fun updateSummary(summary: Summary)
}