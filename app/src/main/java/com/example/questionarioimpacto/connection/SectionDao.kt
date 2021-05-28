package com.example.questionarioimpacto.connection

import androidx.room.Dao
import androidx.room.Query
import com.example.questionarioimpacto.models.SectionBDModel
import kotlinx.coroutines.flow.Flow


@Dao
interface SectionDao {

    @Query("SELECT * FROM section_table")
    fun getSectionList(): Flow<List<SectionBDModel>>
}