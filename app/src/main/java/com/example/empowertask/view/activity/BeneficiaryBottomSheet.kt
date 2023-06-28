package com.example.empowertask.view.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.empowertask.Constants
import com.example.empowertask.R
import com.example.empowertask.databinding.BeneficiaryBottomsheetFragmentBinding
import com.example.empowertask.model.Beneficiary
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

//Created bottom sheet to show Beneficiary in Details
class BeneficiaryBottomSheet(private val beneficiary: Beneficiary) : BottomSheetDialogFragment() {
    //binding view
    private val binding: BeneficiaryBottomsheetFragmentBinding by lazy {
        BeneficiaryBottomsheetFragmentBinding.inflate(layoutInflater)
    }

    override fun getTheme(): Int {
        return R.style.RoundedBottomSheetDialogTheme
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setData()
        return binding.root
    }

    fun setData() {
        //setup detail from beneficiary Item to each filed
        binding.tvName.text = "${beneficiary.firstName} ${beneficiary.lastName}"
        binding.tvBeneTypeValue.text = beneficiary.beneType
        binding.tvDesignationValue.text = when (beneficiary.designationCode) {
            Constants.DESIGNATION_CODE_FOR_PRIMARY -> Constants.DESIGNATION_PRIMARY
            else -> Constants.DESIGNATION_CONTINGENT
        }
        binding.tvSSNValue.text = beneficiary.socialSecurityNumber
        binding.tvDOBValue.text = Constants().convertDate(beneficiary.dateOfBirth)
        binding.tvPhoneValue.text = beneficiary.phoneNumber
        beneficiary.beneficiaryAddress?.apply {
            binding.tvAddressValue.text = firstLineMailing?.plus(",\n")
                .plus(city)
                .plus(",\n")
                .plus(stateCode)
                .plus("-")
                .plus(zipCode)
                .plus(",\n")
                .plus(country)
        }
    }
}