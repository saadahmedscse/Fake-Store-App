package com.saadahmedsoft.fakestoreapp.services.model.product

import com.google.gson.annotations.SerializedName


data class ProductResponse (

  @SerializedName("id"          ) var id          : Int?    = null,
  @SerializedName("title"       ) var title       : String? = null,
  @SerializedName("price"       ) var price       : Double? = null,
  @SerializedName("description" ) var description : String? = null,
  @SerializedName("category"    ) var category    : String? = null,
  @SerializedName("image"       ) var image       : String? = null,
  @SerializedName("rating"      ) var rating      : Rating? = Rating()

)