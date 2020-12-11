//991519115 Karan Patel
package com.profjk.holidaylist.network
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class Holiday(
    @Json(name = "name") val name: String? = null,
    @Json(name = "date") val date: String? = null
)