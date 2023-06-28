package com.example.empowertask.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.empowertask.R
import com.example.empowertask.databinding.ActivityListBeneficiaryBinding
import com.example.empowertask.view.adapter.BeneficiaryListAdapter
import com.example.empowertask.viewmodel.BeneficiaryViewModel

class BeneficiaryListActivity : AppCompatActivity() {
    lateinit var databinding : ActivityListBeneficiaryBinding
    private val beneficiaryViewModel : BeneficiaryViewModel by lazy {
        BeneficiaryViewModel(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_list_beneficiary)
        setUpObserver()
    }

    fun setUpObserver(){
        beneficiaryViewModel.loadBeneficiaries()
        databinding.rvBeneficiaryList.layoutManager = LinearLayoutManager(this)
        beneficiaryViewModel.beneficiaries.observe(this, Observer { beneficiaryList ->
            var beneficiaryListAdapter = BeneficiaryListAdapter()
            beneficiaryListAdapter.setBeneficiaries(beneficiaryList)
        })
    }
}