package br.com.gabrielmarcos.coroutines_sunflower.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Headline(
    @SerializedName("EffectiveDate") val effectiveDate: String?,
    @SerializedName("EffectiveEpochDate") val effectiveEpochDate: Int?,
    @SerializedName("Severity") val severity: Int?,
    @SerializedName("Text") val text: String?,
    @SerializedName("Category") val category: String?,
    @SerializedName("EndDate") val endDate: String?,
    @SerializedName("EndEpochDate") val endEpochDate: Int?,
    @SerializedName("MobileLink") val mobileLink: String?,
    @SerializedName("Link") val link: String?
) : Serializable