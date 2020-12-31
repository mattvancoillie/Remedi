package be.vives.remediapp.navigation.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1, exportSchema = false)
abstract class RemediDatabase : RoomDatabase() {

    abstract val RemediDatabaseDao: RemediDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: RemediDatabase? = null

        fun getInstance(context: Context) : RemediDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RemediDatabase::class.java,
                        "remedi_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }

    }
}