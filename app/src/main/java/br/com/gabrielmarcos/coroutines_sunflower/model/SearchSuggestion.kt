package br.com.gabrielmarcos.coroutines_sunflower.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SearchSuggestion(
    @SerializedName("Version") val version: Int?,
    @SerializedName("Key") val key: String?,
    @SerializedName("Type") val type: String?,
    @SerializedName("LocalizedName") val localizedName: String?,
    @SerializedName("Country") val country: Country?,
    @SerializedName("AdministrativeArea") val administrativeArea: AdministrativeArea?
) : Serializable