package com.example.empowertask.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.empowertask.model.Beneficiary
import com.example.empowertask.repository.BeneficiaryRepository

class BeneficiaryViewModel(private val context: Context) : ViewModel() {
    private val _beneficiaries = MutableLiveData<List<Beneficiary>>()
    val beneficiaries: LiveData<List<Beneficiary>> get() = _beneficiaries

    //load list of beneficiary from Beneficiary.json file
    fun loadBeneficiaries() {
        val beneficiaries = BeneficiaryRepository.getBeneficiaries(context)
        _beneficiaries.value = beneficiaries
    }

    //retrieve data from SSN
    fun getBeneficiaryDetails(ssn: String): Beneficiary? {
        return BeneficiaryRepository.getBeneficiaryDetails(ssn)
    }
}
