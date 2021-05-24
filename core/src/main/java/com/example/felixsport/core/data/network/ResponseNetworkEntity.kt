package com.example.felixsport.core.data.network

import com.google.gson.annotations.SerializedName

data class ResponseNetworkEntity(

	@field:SerializedName("sports")
	val sports: List<SportsItem>
)
