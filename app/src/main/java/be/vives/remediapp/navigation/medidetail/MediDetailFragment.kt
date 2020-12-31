package be.vives.remediapp.navigation.medidetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

class MediDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        @Suppress("UNUSED_VARIABLE")
        val application = requireNotNull(activity).application
        val binding = FragmentMediDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val MedicationProperty = MediDetailFragmentArgs.fromBundle(arguments!!).selectedProperty
        val viewModelFactory = MediDetailViewModelFactory(MedicationProperty, application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MediDetailViewModel::class.java)

        binding.viewModel = viewModel
        return binding.root
        // Inflate the layout for this fragment
    }
}
