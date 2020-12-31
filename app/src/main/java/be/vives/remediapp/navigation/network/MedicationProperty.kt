package be.vives.remediapp.navigation.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MedicationProperty (
    val id: String,
            @Json(name = "results") val Results: String
) : Parcelable {
    val getResults
    get() = Results == "results"
}