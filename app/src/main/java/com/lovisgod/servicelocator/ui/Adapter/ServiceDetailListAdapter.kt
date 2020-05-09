package com.lovisgod.servicelocator.ui.Adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.lovisgod.servicelocator.R
import com.lovisgod.servicelocator.databinding.ServiceDetailItemBinding
import com.lovisgod.servicelocator.databinding.ServiceItemBinding
import com.lovisgod.servicelocator.model.Service
import com.lovisgod.servicelocator.model.ServiceDetails
import com.lovisgod.servicelocator.viewmodel.BusinnessViewModel

class ServiceDetailListAdapter(viewmodel: BusinnessViewModel): RecyclerView.Adapter<ServiceDetailListAdapter.viewHolder>() {

    private var serviceList: ArrayList<ServiceDetails> = ArrayList()


    class viewHolder(itemView: ServiceDetailItemBinding): RecyclerView.ViewHolder(itemView.root) {
        var title = itemView.catTitle
        var description = itemView.catDescription
        var selectBtn = itemView.selectCat
        var layout = itemView.serviceCat
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView: ServiceDetailItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.service_detail_item,
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
        var selected = false
        holder.title.text = service.title
        holder.description.text = service.description
        holder.selectBtn.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (selected) {
                    selected = false
                    holder.selectBtn.setImageDrawable(holder.layout.context.getDrawable(R.drawable.ic_add_circle_black_24dp))
                    holder.selectBtn.setBackgroundColor(holder.layout.context.getColor(R.color.white))
                } else {
                    selected = true
                    holder.selectBtn.setBackgroundColor(holder.layout.context.getColor(R.color.black))
                }

            }
        }
//        holder.layout.setOnClickListener {
//            Toast.makeText(holder.layout.context, "This is a service", Toast.LENGTH_LONG).show()
//        }
    }

    fun setDataList(serviceList: ArrayList<ServiceDetails>) {
        this.serviceList = serviceList
    }
}