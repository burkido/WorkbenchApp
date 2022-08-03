package com.project.workbenchapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.workbenchapp.data.local.dao.HeroDao
import com.project.workbenchapp.domain.model.Hero
import com.project.workbenchapp.domain.model.HeroRemoteKey


@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class WorkbenchDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
}