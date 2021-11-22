package com.pm.aa.data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Product")
class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val marca: String,
    val teor: String

    ) : Parcelable