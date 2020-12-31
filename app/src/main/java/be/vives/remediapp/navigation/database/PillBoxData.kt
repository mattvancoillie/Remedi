package be.vives.remediapp.navigation.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pillbox_data")
data class PillBoxData (
    @PrimaryKey(autoGenerate = true)
    var PillBoxId: Long = 0L,

    val weekTime: String,
    val ingestionTime: String,
    val weekDay: String,
    val partOfDay: String,
    val medicationName: String,
    val medicationDosis: String,
    val tookMedication: Boolean
)