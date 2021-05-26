package com.shivam.kotlin.appscriptask.repository

import com.shivam.kotlin.appscriptask.database.SummaryDao
import com.shivam.kotlin.appscriptask.modal.Summary
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameOverRepository @Inject constructor(
    private val summaryDao: SummaryDao
){
    suspend fun insertSummaryIntoTable(summary: Summary){
        summaryDao.insertSummary(summary)
    }
}