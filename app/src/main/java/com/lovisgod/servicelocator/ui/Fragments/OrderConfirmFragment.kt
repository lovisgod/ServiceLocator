package com.lovisgod.servicelocator.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar

import com.lovisgod.servicelocator.R
import com.lovisgod.servicelocator.databinding.FragmentLoginBinding
import com.lovisgod.servicelocator.databinding.FragmentOrderConfirmBinding
import com.lovisgod.servicelocator.viewmodel.AuthViewModel
import com.lovisgod.servicelocator.viewmodel.BusinnessViewModel

/**
 * A simple [Fragment] subclass.
 */
class OrderConfirmFragment : Fragment() {
    private lateinit var binding : FragmentOrderConfirmBinding
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_order_confirm, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        binding.payButton.setOnClickListener {
            Snackbar.make(binding.bottomLay, "Payment successful", Snackbar.LENGTH_LONG).show()
            navController.navigate(R.id.landingFragment)
        }
        return binding.root
    }

}
