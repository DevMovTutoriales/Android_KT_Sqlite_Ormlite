package com.example.android_kt_sqlite_ormlite

import android.content.Context
import com.j256.ormlite.android.apptools.OpenHelperManager
import com.j256.ormlite.dao.Dao

class UserNameRepository(context: Context) {

    private var dao: Dao<UserName, Int>

    init {
        val helper = OpenHelperManager.getHelper(context, DBUser::class.java)
        dao = helper.getDao(UserName::class.java)
    }

    fun getNames(): List<UserName>{
        return dao.queryForAll()
    }

    fun addName(name: UserName){
        dao.create(name)
    }

    fun deleteAll(id: Int){
        dao.deleteById(id)
    }

}