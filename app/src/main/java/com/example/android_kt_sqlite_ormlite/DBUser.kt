package com.example.android_kt_sqlite_ormlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils

class DBUser(context: Context): OrmLiteSqliteOpenHelper(
    context,
    "Users",
    null,
    1
) {
    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        TableUtils.createTable(connectionSource, UserName::class.java)
    }

    override fun onUpgrade(
        database: SQLiteDatabase?,
        connectionSource: ConnectionSource?,
        oldVersion: Int,
        newVersion: Int
    ) {
    }
}