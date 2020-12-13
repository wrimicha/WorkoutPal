package sheridan.wrimicha.final_project

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BenchEntity::class], version = 1, exportSchema = false)
abstract class BenchDatabase: RoomDatabase(){

    abstract val benchDao: BenchDao

    companion object{

        @Volatile
        private var INSTANCE: BenchDatabase? = null

        fun getInstance(context: Context): BenchDatabase {

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BenchDatabase::class.java,
                        "bench_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}