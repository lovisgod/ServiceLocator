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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.lovisgod.servicelocator.R
import com.lovisgod.servicelocator.databinding.FragmentServiceDetailsBinding
import com.lovisgod.servicelocator.databinding.FragmentServiceListBinding
import com.lovisgod.servicelocator.model.Service
import com.lovisgod.servicelocator.model.ServiceDetails
import com.lovisgod.servicelocator.ui.Adapter.ServiceDetailListAdapter
import com.lovisgod.servicelocator.ui.Adapter.ServiceListAdapter
import com.lovisgod.servicelocator.viewmodel.BusinnessViewModel

/**
 * A simple [Fragment] subclass.
 */
class ServiceDetailsFragment : Fragment() {
    private lateinit var binding: FragmentServiceDetailsBinding
    private lateinit var navController: NavController
    private lateinit var adapter: ServiceDetailListAdapter
    private val viewModel: BusinnessViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(activity, BusinnessViewModel.Factory(activity.application))
            .get(BusinnessViewModel::class.java)
    }

    val serviceList: ArrayList<ServiceDetails> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        navController = Navigation.findNavController(this.requireActivity(), R.id.app_nav_host_fragment)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_service_details, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        adapter = ServiceDetailListAdapter(viewModel)

        binding.topServices.layoutManager = LinearLayoutManager(this.requireContext(),
            LinearLayoutManager.VERTICAL, false)

        val serv1 = ServiceDetails(title = "Category One", description = "This is sample detail", price = "$40/unit")
        val serv2 = ServiceDetails(title = "Category One", description = "This is sample detail", price = "$40/unit")
        val serv3 = ServiceDetails(title = "Category One", description = "This is sample detail", price = "$40/unit")
        val serv4 = ServiceDetails(title = "Category One", description = "This is sample detail", price = "$40/unit")
        val serv5 = ServiceDetails(title = "Category One", description = "This is sample detail", price = "$40/unit")
        val serv6 = ServiceDetails(title = "Category One", description = "This is sample detail", price = "$40/unit")

        serviceList.add(serv1)
        serviceList.add(serv2)
        serviceList.add(serv3)
        serviceList.add(serv4)
        serviceList.add(serv5)
        serviceList.add(serv6)

        binding.topServices.adapter = adapter
        adapter.setDataList(serviceList)


        binding.payButton.setOnClickListener {
            navController.navigate(R.id.action_serviceDetailsFragment_to_orderConfirmFragment)
        }
        return binding.root
    }

}
