package com.pm.aa.data.database

import android.content.Context
import android.provider.ContactsContract
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pm.aa.data.dao.ProductDao
import com.pm.aa.data.entities.Product

@Database(entities = [Product :: class],
    version = 2,
    exportSchema = true,
    autoMigrations = [AutoMigration (from = 1, to = 2)])
abstract class DatabaseGarrafeira : RoomDatabase(){
    abstract fun ProductDao() : ProductDao
    companion object {
        @Volatile
        private var INSTANCE: DatabaseGarrafeira? = null

        fun getDatabase(context: Context): DatabaseGarrafeira{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseGarrafeira::class.java,
                    "Garrafeira_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}