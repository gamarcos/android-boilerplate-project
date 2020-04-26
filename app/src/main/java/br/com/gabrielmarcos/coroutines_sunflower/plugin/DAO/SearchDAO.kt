package br.com.gabrielmarcos.coroutines_sunflower.plugin.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SearchDAO {

    // @Query("SELECT * FROM themes ORDER BY id DESC")
    // fun getLegoThemes(): LiveData<List<LegoTheme>>
    //
    // @Insert(onConflict = OnConflictStrategy.REPLACE)
    // suspend fun insertAll(plants: List<LegoTheme>)
}