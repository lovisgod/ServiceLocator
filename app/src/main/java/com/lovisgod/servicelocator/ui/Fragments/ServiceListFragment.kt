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
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import com.lovisgod.servicelocator.R
import com.lovisgod.servicelocator.databinding.FragmentServiceListBinding
import com.lovisgod.servicelocator.model.Service
import com.lovisgod.servicelocator.ui.Adapter.ServiceListAdapter
import com.lovisgod.servicelocator.viewmodel.BusinnessViewModel

/**
 * A simple [Fragment] subclass.
 */
class ServiceListFragment : Fragment() {
    private lateinit var binding: FragmentServiceListBinding
    private lateinit var navController: NavController
    private lateinit var adapter: ServiceListAdapter
    private val viewModel: BusinnessViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(activity, BusinnessViewModel.Factory(activity.application))
            .get(BusinnessViewModel::class.java)
    }

    val serviceList: ArrayList<Service> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        navController = Navigation.findNavController(this.requireActivity(), R.id.app_nav_host_fragment)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_service_list, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        adapter = ServiceListAdapter(viewModel)

        binding.topServices.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val serv1 = Service(name = "Service sample one")
        val serv2 = Service(name = "Service sample two")
        val serv3 = Service(name = "Service sample three")
        val serv4 = Service(name = "Service sample four")
        val serv5 = Service(name = "Service sample five")
        val serv6 = Service(name = "Service sample six")

        serviceList.add(serv1)
        serviceList.add(serv2)
        serviceList.add(serv3)
        serviceList.add(serv4)
        serviceList.add(serv5)
        serviceList.add(serv6)

        binding.topServices.adapter = adapter
        adapter.setDataList(serviceList)
        return binding.root
    }

}
