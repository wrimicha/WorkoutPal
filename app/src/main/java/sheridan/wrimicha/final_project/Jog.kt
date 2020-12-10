package sheridan.wrimicha.final_project

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jogData")
data class Jog(
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @ColumnInfo(name = "kms")
    val value: String,
    @ColumnInfo(name = "year")
    val year: Int,
    @ColumnInfo(name = "month")
    val month: Int,
    @ColumnInfo(name = "day")
    val day: Int,
    @ColumnInfo(name = "duration")
val duration : String
)