package com.example.empowertask.model

import java.io.Serializable

data class Beneficiary(

    var lastName: String? = "",
    var firstName: String? = "",
    var designationCode: String? = "",
    var beneType: String? = "",
    var socialSecurityNumber: String? = "",
    var dateOfBirth: String? = "",
    var middleName: String? = "",
    var phoneNumber: String? = "",
    var beneficiaryAddress: BeneficiaryAddress? = BeneficiaryAddress()
) : Serializable

data class BeneficiaryAddress(

    var firstLineMailing: String? = "",
    var scndLineMailing: String? = "",
    var city: String? = "",
    var zipCode: String? = "",
    var stateCode: String? = "",
    var country: String? = ""

)