package com.example.empowertask.repository

import android.content.Context
import com.example.empowertask.model.Beneficiary
import com.example.empowertask.model.BeneficiaryAddress
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

object BeneficiaryRepository {
    private var beneficiaries: List<Beneficiary> = emptyList()

    fun getBeneficiaries(context: Context): List<Beneficiary> {
        if (beneficiaries.isEmpty()) {
            val json = readJsonFromAssets(context, "Beneficiaries.json")
            beneficiaries = parseBeneficiaries(json)
        }
        return beneficiaries
    }

    fun parseBeneficiaries(json: String): List<Beneficiary> {
        val beneficiaries = mutableListOf<Beneficiary>()

        try {
            val jsonArray = JSONArray(json)
            for (i in 0 until jsonArray.length()) {
                val jsonObject: JSONObject = jsonArray.getJSONObject(i)

                val lastName = jsonObject.getString("lastName")
                val firstName = jsonObject.getString("firstName")
                val designationCode = jsonObject.getString("designationCode")
                val beneType = jsonObject.getString("beneType")
                val socialSecurityNumber = jsonObject.getString("socialSecurityNumber")
                val dateOfBirth = jsonObject.getString("dateOfBirth")
                val middleName = jsonObject.getString("middleName")
                val phoneNumber = jsonObject.getString("phoneNumber")


                val beneficiaryAddressObject: JSONObject = jsonObject.getJSONObject("beneficiaryAddress")

                val firstLineMailing = beneficiaryAddressObject.getString("firstLineMailing")
                val scndLineMailing = beneficiaryAddressObject.getString("scndLineMailing")
                val city = beneficiaryAddressObject.getString("city")
                val zipCode = beneficiaryAddressObject.getString("zipCode")
                val stateCode = beneficiaryAddressObject.getString("stateCode")
                val country = beneficiaryAddressObject.getString("country")

                val beneficiary = Beneficiary(
                    lastName,
                    firstName,
                    designationCode,
                    beneType,
                    socialSecurityNumber,
                    dateOfBirth,
                    middleName,
                    phoneNumber,
                    BeneficiaryAddress(firstLineMailing,scndLineMailing,city,zipCode,stateCode,country)
                )
                beneficiaries.add(beneficiary)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return beneficiaries
    }

    fun getBeneficiaryDetails(socialSecurityNumber: String): Beneficiary? {
        return beneficiaries.find { it.socialSecurityNumber == socialSecurityNumber }
    }

    fun readJsonFromAssets(context: Context, fileName: String): String {
        val jsonString: String
        try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            jsonString = String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
            return ""
        }
        return jsonString
    }

}
