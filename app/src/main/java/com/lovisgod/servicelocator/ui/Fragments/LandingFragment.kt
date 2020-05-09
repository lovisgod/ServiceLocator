package com.lovisgod.servicelocator.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar

import com.lovisgod.servicelocator.R
import com.lovisgod.servicelocator.databinding.FragmentLandingBinding
import com.lovisgod.servicelocator.databinding.FragmentLoginBinding
import com.lovisgod.servicelocator.viewmodel.AuthViewModel
import com.lovisgod.servicelocator.viewmodel.BusinnessViewModel

/**
 * A simple [Fragment] subclass.
 */
class LandingFragment : Fragment() {
    private lateinit var binding : FragmentLandingBinding
    private lateinit var navController: NavController

    private val viewModel: BusinnessViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(activity, BusinnessViewModel.Factory(activity.application))
            .get(BusinnessViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        navController = Navigation.findNavController(this.requireActivity(), R.id.app_nav_host_fragment)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_landing, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        binding.contactUs.setOnClickListener {
            Toast.makeText(this.requireContext(), "This will handle contact us", Toast.LENGTH_LONG).show()
        }

        binding.installation.setOnClickListener {
            Toast.makeText(this.requireContext(), "This will go to list", Toast.LENGTH_LONG).show()
            gotoList()
        }

        binding.repair.setOnClickListener {
            Toast.makeText(this.requireContext(), "This will go to list", Toast.LENGTH_LONG).show()
            gotoList()
        }

        binding.transport.setOnClickListener {
            Toast.makeText(this.requireContext(), "This will go to list", Toast.LENGTH_LONG).show()
            gotoList()
        }

        binding.cleaner.setOnClickListener {
            Toast.makeText(this.requireContext(), "This will go to  list", Toast.LENGTH_LONG).show()
            gotoList()
        }

        binding.service1.setOnClickListener {
            Toast.makeText(this.requireContext(), "This will go to details", Toast.LENGTH_LONG).show()
            gotoDetails()
        }

        binding.service2.setOnClickListener {
            Toast.makeText(this.requireContext(), "This will go to details", Toast.LENGTH_LONG).show()
            gotoDetails()
        }

        binding.service3.setOnClickListener {
            Toast.makeText(this.requireContext(), "This will go to details", Toast.LENGTH_LONG).show()
            gotoDetails()
        }

        binding.service4.setOnClickListener {
            Toast.makeText(this.requireContext(), "This will go to details", Toast.LENGTH_LONG).show()
            gotoDetails()
        }


        return binding.root

    }

    fun gotoList() {
        navController.navigate(R.id.action_landingFragment_to_serviceListFragment)
    }

    fun gotoDetails() {
        navController.navigate(R.id.action_landingFragment_to_serviceDetailsFragment)
    }


}
