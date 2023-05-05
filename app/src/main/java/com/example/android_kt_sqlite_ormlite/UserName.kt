package com.example.android_kt_sqlite_ormlite

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

@DatabaseTable(tableName = "Names")
class UserName {

    @DatabaseField(id = true)
    private var id: Int? = null

    @DatabaseField
    private var name: String? = null


    fun setName(nombre: String?) {
        this.name = nombre
    }

    fun getName(): String? {
        return name
    }

    fun getId(): Int? {
        return id
    }
}