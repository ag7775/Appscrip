package com.shivam.kotlin.appscriptask.view_models

import androidx.lifecycle.ViewModel
import com.shivam.kotlin.appscriptask.repository.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


//ViewModel for History Page - Resposible for fetching the data from repository
@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val historyRepository: HistoryRepository
) : ViewModel() {

    val summaryList = historyRepository.getAllSummaryData()
    
}