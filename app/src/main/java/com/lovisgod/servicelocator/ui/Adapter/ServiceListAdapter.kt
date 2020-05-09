package com.lovisgod.servicelocator.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.lovisgod.servicelocator.R
import com.lovisgod.servicelocator.databinding.ServiceItemBinding
import com.lovisgod.servicelocator.model.Service
import com.lovisgod.servicelocator.viewmodel.BusinnessViewModel

class ServiceListAdapter(viewmodel: BusinnessViewModel): RecyclerView.Adapter<ServiceListAdapter.viewHolder>() {

    private var serviceList: ArrayList<Service> = ArrayList()


    class viewHolder(itemView: ServiceItemBinding): RecyclerView.ViewHolder(itemView.root) {
        val title = itemView.title
        val layout = itemView.service
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView: ServiceItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.service_item,
            parent, false)
        return viewHolder(itemView)
    }

    override fun getItemCount(): Int {
        if (serviceList.isNotEmpty()){
            return serviceList.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val service = serviceList.get(position)
        holder.title.text  = service.name
        holder.layout.setOnClickListener {
            Toast.makeText(holder.layout.context, "This is a service", Toast.LENGTH_LONG).show()
            Navigation.findNavController(holder.layout).navigate(R.id.action_serviceListFragment_to_serviceDetailsFragment)
        }
    }

    fun setDataList(serviceList: ArrayList<Service>) {
         this.serviceList = serviceList
    }
}