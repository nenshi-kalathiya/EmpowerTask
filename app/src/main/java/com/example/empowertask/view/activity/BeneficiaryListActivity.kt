package com.example.empowertask.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.empowertask.Constants.Companion.BENEFICIARY_BOTTOM_SHEET_DIALOG
import com.example.empowertask.R
import com.example.empowertask.databinding.ActivityListBeneficiaryBinding
import com.example.empowertask.model.Beneficiary
import com.example.empowertask.view.adapter.BeneficiaryListAdapter
import com.example.empowertask.viewmodel.BeneficiaryViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.shape.MaterialShapeDrawable

class BeneficiaryListActivity : AppCompatActivity() {
    lateinit var databinding: ActivityListBeneficiaryBinding
    private val beneficiaryViewModel: BeneficiaryViewModel by lazy {
        BeneficiaryViewModel(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_list_beneficiary)
        setUpObserver()
    }

    //setup observer & retrieve data and setin adapter
    fun setUpObserver() {
        beneficiaryViewModel.loadBeneficiaries()
        databinding.rvBeneficiaryList.layoutManager = LinearLayoutManager(this)
        var beneficiaryListAdapter = BeneficiaryListAdapter { beneficiary ->
            showBeneficiaryDetails(beneficiary)
        }
        databinding.rvBeneficiaryList.adapter = beneficiaryListAdapter
        beneficiaryViewModel.beneficiaries.observe(this, Observer { beneficiaryList ->
            beneficiaryListAdapter.setBeneficiaries(beneficiaryList)
        })
    }

    //call bottomsheet while click on Single Item for list
    private fun showBeneficiaryDetails(beneficiary: Beneficiary) {
        BeneficiaryDetailsBottomSheet(beneficiary).show(
            this.supportFragmentManager,
            BENEFICIARY_BOTTOM_SHEET_DIALOG
        )
    }
}