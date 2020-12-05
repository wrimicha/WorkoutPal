package sheridan.sharm212.workout

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Jog::class], version = 1, exportSchema = false)
abstract class JogDatabase: RoomDatabase(){

    abstract val rollerDao: JogDao

    companion object{

        @Volatile
        private var INSTANCE: JogDatabase? = null

        fun getInstance(context: Context): JogDatabase {

            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        JogDatabase::class.java,
                        "envelop_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }

}