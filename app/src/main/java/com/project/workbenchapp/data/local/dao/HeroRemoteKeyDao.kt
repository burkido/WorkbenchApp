package com.project.workbenchapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.workbenchapp.domain.model.HeroRemoteKey

@Dao
interface HeroRemoteKeyDao {

    @Query("SELECT * FROM HERO_REMOTE_KEY_TABLE WHERE ID = :id")
    suspend fun getRemoteKEY(id: Int) : HeroRemoteKey?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteKey: List<HeroRemoteKey>) : HeroRemoteKey?

    @Query("DELETE FROM HERO_REMOTE_KEY_TABLE")
    suspend fun deleteAllRemoteKeys()
}