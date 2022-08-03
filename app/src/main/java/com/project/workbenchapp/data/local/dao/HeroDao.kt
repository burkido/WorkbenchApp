package com.project.workbenchapp.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.workbenchapp.domain.model.Hero

interface HeroDao {

    @Query("SELECT * FROM HERO_TABLE ORDER BY ID ASC")
    fun getAllHeroes() : PagingSource<Int, Hero>

    @Query("SELECT * FROM HERO_TABLE WHERE ID=:heroId")
    fun getSelectedHero(heroId: Int): Hero

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHeroes(heroes: List<Hero>)

    @Query("DELETE FROM HERO_TABLE")
    suspend fun deleteAllHeroes()

    @Query("DELETE FROM HERO_TABLE WHERE ID=:heroId")
    suspend fun deleteSelectedHero(heroId: Int)
}