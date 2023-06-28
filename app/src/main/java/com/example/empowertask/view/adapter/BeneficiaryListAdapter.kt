package com.example.empowertask.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.empowertask.Constants
import com.example.empowertask.databinding.ItemBeneficiarryBinding
import com.example.empowertask.model.Beneficiary

class BeneficiaryListAdapter( private val onItemClick: (Beneficiary) -> Unit) : RecyclerView.Adapter<BeneficiaryListAdapter.ViewHolder>() {
    private var beneficiaries: List<Beneficiary> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBeneficiarryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return beneficiaries.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        beneficiaries?.get(position)?.let { beneficiaryItem ->
            holder.bindData(beneficiaryItem)
            holder.itemView.setOnClickListener { onItemClick(beneficiaryItem) }
        }
    }

    class ViewHolder(private val binding: ItemBeneficiarryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: Beneficiary) {
            //data binding directly with UI for name and benetype
            binding.beneficiary = data
            binding.tvDesignation.text =   when(data.designationCode){
                Constants.DESIGNATION_CODE_FOR_PRIMARY ->  Constants.DESIGNATION.plus(Constants.DESIGNATION_PRIMARY)
                else ->  Constants.DESIGNATION.plus(Constants.DESIGNATION_CONTINGENT)
            }
        }
    }

    fun setBeneficiaries(beneficiaries: List<Beneficiary>) {
        this.beneficiaries = beneficiaries
        notifyDataSetChanged()
    }
}
