package be.vives.remediapp.navigation.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medication_data")
data class MedicationData(
    @PrimaryKey(autoGenerate = true)
    var medicationId: Long = 0L,

    val medicationName: String,
    val typeOfMedication: String,
    val medicationDosis: Double,
    val medicationSummary: String,
    val ingestionTime: String
)