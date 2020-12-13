package sheridan.wrimicha.final_project

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface JogDao {

    @Insert
    suspend fun insert(jog: Jog): Long

    @Query("SELECT * FROM jogData ORDER BY id")
    fun getAll() : LiveData<List<Jog>>

    @Query("DELETE FROM jogData")
    suspend fun deleteAll()

    @Query("DELETE FROM jogData WHERE id=:id")
    suspend fun delete(id: Long)

    @Update
    suspend fun update(jog: Jog)

}