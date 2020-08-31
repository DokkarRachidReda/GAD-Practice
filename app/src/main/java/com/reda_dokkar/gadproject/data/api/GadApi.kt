package com.reda_dokkar.gadproject.data.api

import com.reda_dokkar.gadproject.data.model.LearningItem
import com.reda_dokkar.gadproject.data.model.SkillItem
import retrofit2.Call
import retrofit2.http.*

interface GadApi {


    @GET("api/hours")
    fun getLearningLeaders(): Call<ArrayList<LearningItem>>


    @GET("api/skilliq")
    fun getSkillIQLeaders(): Call<ArrayList<SkillItem>>


    @POST
    @FormUrlEncoded
    fun submit(@Url url:String = "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse",
                @Field("entry.1824927963") email:String,
                @Field("entry.1877115667") name:String,
                @Field("entry.2006916086") lastName:String,
                @Field("entry.284483984") link:String
    ) :  Call<Any?>
}