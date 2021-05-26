package com.shivam.kotlin.appscriptask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shivam.kotlin.appscriptask.modal.Summary
import dagger.hilt.android.qualifiers.ApplicationContext

@Database(entities = [Summary::class], version = 1, exportSchema = false)
abstract class SummaryDatabase : RoomDatabase() {
    abstract fun getSummaryDao(): SummaryDao

    companion object {
        @Volatile
        private var INSTANCE: SummaryDatabase? = null

        fun getSummaryDatabase(@ApplicationContext context: Context): SummaryDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        SummaryDatabase::class.java,
                        "summary_db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}