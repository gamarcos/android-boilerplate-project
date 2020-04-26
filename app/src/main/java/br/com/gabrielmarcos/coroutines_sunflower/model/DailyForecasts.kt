package br.com.gabrielmarcos.coroutines_sunflower.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DailyForecasts (
    @SerializedName("Date") val date : String?,
    @SerializedName("EpochDate") val epochDate : Int?,
    @SerializedName("Temperature") val temperature : Temperature?,
    @SerializedName("Day") val day : Day?,
    @SerializedName("Night") val night : Night?,
    @SerializedName("Sources") val sources : List<String>?,
    @SerializedName("MobileLink") val mobileLink : String?,
    @SerializedName("Link") val link : String?
) : Serializable

data class Day (
    @SerializedName("Icon") val icon : Int?,
    @SerializedName("IconPhrase") val iconPhrase : String?,
    @SerializedName("HasPrecipitation") val hasPrecipitation : Boolean?
) : Serializable

data class Night (
    @SerializedName("Icon") val icon : Int?,
    @SerializedName("IconPhrase") val iconPhrase : String?,
    @SerializedName("HasPrecipitation") val hasPrecipitation : Boolean?
) : Serializable

data class Temperature (
    @SerializedName("Minimum") val minimum : Minimum?,
    @SerializedName("Maximum") val maximum : Maximum?
) : Serializable

data class Maximum (
    @SerializedName("Value") val value : Int?,
    @SerializedName("Unit") val unit : String?,
    @SerializedName("UnitType") val unitType : Int?
) : Serializable

data class Minimum (
    @SerializedName("Value") val value : Int?,
    @SerializedName("Unit") val unit : String?,
    @SerializedName("UnitType") val unitType : Int?
) : Serializable