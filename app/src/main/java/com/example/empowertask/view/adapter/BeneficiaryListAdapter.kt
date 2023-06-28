package com.example.empowertask.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.empowertask.Constants
import com.example.empowertask.databinding.ItemBeneficiarryBinding
import com.example.empowertask.model.Beneficiary


class BeneficiaryListAdapter() : RecyclerView.Adapter<BeneficiaryListAdapter.ViewHolder>() {
    private var beneficiaries: List<Beneficiary> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBeneficiarryBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return beneficiaries.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        beneficiaries?.get(position)?.let { beneficiaryItem ->
            holder.bindData(beneficiaryItem)
        }
    }

    class ViewHolder(private val binding: ItemBeneficiarryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: Beneficiary) {
            if(data.designationCode.equals(Constants.DESIGNATION_CODE_FOR_PRIMARY)) {
                binding.tvDesignation.text = Constants.DESIGNATION_PRIMARY
            } else {
                binding.tvDesignation.text = Constants.DESIGNATION_CONTINGENT
            }

        }
    }

    fun setBeneficiaries(beneficiaries: List<Beneficiary>) {
        this.beneficiaries = beneficiaries
        notifyDataSetChanged()
    }

}
