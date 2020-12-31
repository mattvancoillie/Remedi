package be.vives.remediapp.navigation.medidetail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import be.vives.remediapp.navigation.network.MedicationProperty
import java.lang.IllegalArgumentException

class MediDetailViewModelFactory (
    private val medicationProperty: MedicationProperty,
    private val application: Application) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(MediDetailViewModel::class.java)) {
        return MediDetailViewModel(medicationProperty, application) as T
    }
            throw IllegalArgumentException("Unknown ViewModel Class")
    }

}
