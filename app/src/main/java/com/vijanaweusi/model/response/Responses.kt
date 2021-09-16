package com.vijanaweusi.model.response

import com.google.gson.annotations.SerializedName

data class CockTailsCategoryResponse (val drinks: List<CockTailsResponse>) {

    data class CockTailsResponse(
        @SerializedName("idDrink")  val id: String,
        @SerializedName("strDrink")  val name: String,
        @SerializedName("strCategory")  val type: String,
        @SerializedName("strInstructions")  val instructions: String,
        @SerializedName( "strCategory")  val category: String,
        @SerializedName( "strDrinkThumb")  val imageUrl: String,
        @SerializedName( "strIngredient1")  val ingredient1: String,
        @SerializedName( "strIngredient2")  val ingredient2: String,
        @SerializedName( "strIngredient3")  val ingredient3: String,
        @SerializedName( "strIngredient4")  val ingredient4: String,
        @SerializedName( "strIngredient5")  val ingredient5: String,
        @SerializedName( "strIngredient6")  val ingredient6: String,
    )

}