package com.example.empowertask

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class Constants {
    companion object {
        var DESIGNATION_CODE_FOR_PRIMARY = "P"
        var DESIGNATION = "Designation: "
        var DESIGNATION_PRIMARY = "Primary"
        var DESIGNATION_CONTINGENT = "Contingent"
        var BENEFICIARY_BOTTOM_SHEET_DIALOG = "BeneficiaryBottamSheet"
    }

    fun convertDate(dateString: String?): String {
        val inputFormat = SimpleDateFormat("MMddyyyy", Locale.getDefault())
        val outputFormat = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        val date: Date = inputFormat.parse(dateString)
        return outputFormat.format(date)
    }
}