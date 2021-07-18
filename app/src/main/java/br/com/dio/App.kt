package br.com.dio

import android.app.Application
import br.com.dio.data.AppDatabase
import br.com.dio.data.BusinessCardRepository

class App : Application()
{
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }

}