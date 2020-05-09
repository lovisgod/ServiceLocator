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

import com.lovisgod.servicelocator.R
import com.lovisgod.servicelocator.databinding.FragmentSignUpBinding
import com.lovisgod.servicelocator.databinding.FragmentVerifyBinding
import com.lovisgod.servicelocator.viewmodel.AuthViewModel

/**
 * A simple [Fragment] subclass.
 */
class VerifyFragment : Fragment() {
    private lateinit var binding : FragmentVerifyBinding
    private lateinit var navController: NavController

    private val viewModel: AuthViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(activity, AuthViewModel.Factory(activity.application))
            .get(AuthViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        navController = Navigation.findNavController(this.requireActivity(), R.id.auth_nav_host_fragment)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_verify, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        binding.loginBtn.setOnClickListener {

        }
        return binding.root    }

}
