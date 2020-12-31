package be.vives.remediapp.navigation.overviewmedi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.vives.remediapp.navigation.network.MedicationProperty
import be.vives.remediapp.navigation.network.RemediApi
import be.vives.remediapp.navigation.network.RemediApiFilter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

enum class RemediApiStatus {LOADING, ERROR, DONE}

class MediViewModel : ViewModel() {

    private val _properties = MutableLiveData<List<MedicationProperty>>()
    val properties : LiveData<List<MedicationProperty>>
    get() = _properties

    private val _status = MutableLiveData<RemediApiStatus>()
    val status : LiveData<RemediApiStatus>
    get() = _status

    private val _navigateToSelectedProperty = MutableLiveData<MedicationProperty>()
    val navigateToSelectedProperty : LiveData<MedicationProperty>
    get() = _navigateToSelectedProperty

    fun displayPropertyDetails (medicationProperty: MedicationProperty)
    {
        _navigateToSelectedProperty.value = medicationProperty
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getMedicationProperties(RemediApiFilter.SHOW_RESULTS)
    }

    private fun getMedicationProperties(filter: RemediApiFilter) {
        coroutineScope.launch {
            var getPropertiesDeferred = RemediApi.retrofitService.getProperties(filter.value)
            try {
                _status.value =
                    RemediApiStatus.LOADING
                var listResult = getPropertiesDeferred.await()
                _status.value =
                    RemediApiStatus.DONE

                if (listResult.isNotEmpty()) {
                    _properties.value = listResult
                }
            } catch (t: Throwable) {
                _status.value =
                    RemediApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }

    }

    fun updateFilter(filter: RemediApiFilter) {
        getMedicationProperties(filter)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}