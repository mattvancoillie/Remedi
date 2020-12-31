package be.vives.remediapp.navigation.medidetail

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import be.vives.remediapp.navigation.network.MedicationProperty

class MediDetailViewModel(medicationProperty: MedicationProperty, app : Application) : AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<MedicationProperty>()
    val selectedProperty : LiveData<MedicationProperty>
    get() = _selectedProperty

    init {
        _selectedProperty.value = medicationProperty
    }

    val displayProperties = Transformations.map(selectedProperty) {
        app.applicationContext.getString(
           )
    }
}

private fun Context.getString() {

}
