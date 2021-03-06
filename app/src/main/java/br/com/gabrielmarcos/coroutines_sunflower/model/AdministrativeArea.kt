package br.com.gabrielmarcos.coroutines_sunflower.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AdministrativeArea(
    @SerializedName("ID") val id: String?,
    @SerializedName("LocalizedName") val localizedName: String?
) : Serializable