package be.vives.remediapp.navigation.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "user_data")
data class UserData (
    @PrimaryKey(autoGenerate = true)
    var UserDataId: Long = 0L,

    val firstName: String,
    val lastName: String,
    //val birthDate: Date,
    val gender: String,

    val bloodType: String,
    val telephoneNumber: Long,
    val disease: String,
    val aboutDisease: String,
    val adress: String
    )
