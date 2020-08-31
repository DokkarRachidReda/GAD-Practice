package com.reda_dokkar.gadproject.data.api

import com.reda_dokkar.gadproject.data.model.LearningItem
import com.reda_dokkar.gadproject.data.model.SkillItem
import retrofit2.Call
import retrofit2.http.GET

interface GadApi {


    @GET("api/hours")
    fun getLearningLeaders(): Call<ArrayList<LearningItem>>


    @GET("api/skilliq")
    fun getSkillIQLeaders(): Call<ArrayList<SkillItem>>
}