package com.example.demojetpack.models

import com.google.gson.annotations.SerializedName


data class ExampleJson2KtKotlin (

  @SerializedName("lat"            ) var lat            : String? = null,
  @SerializedName("lng"            ) var lng            : String? = null,
  @SerializedName("radiusInMeters" ) var radiusInMeters : String? = null

)