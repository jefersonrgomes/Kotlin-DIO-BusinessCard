package br.com.dio.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BusinessCard::class], version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun businessDao():BusinessCardDao
    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "businesscard4_db"
                ).build()

                INSTANCE = instance
                instance
            }
        }

    }

    //Cor verde 0- #00FF00
    //Cor azul bebe -  #64D3C8
    //Cor Laranja - E64610

}