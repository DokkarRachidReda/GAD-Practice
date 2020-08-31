package com.reda_dokkar.gadproject.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.reda_dokkar.gadproject.data.api.GadApi
import com.reda_dokkar.gadproject.data.apiUrl
import com.reda_dokkar.gadproject.data.model.LearningItem
import com.reda_dokkar.gadproject.data.model.SkillItem
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseRepository {

    private  var gadApi : GadApi
    var learningLiveData : MutableLiveData<ArrayList<LearningItem>> = MutableLiveData()
    var skillLiveData : MutableLiveData<ArrayList<SkillItem>> = MutableLiveData()
    var submitLiveData : MutableLiveData<Boolean> = MutableLiveData()

    init {
        val client = OkHttpClient
            .Builder()
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        gadApi = retrofit.create(GadApi::class.java)
    }


    fun getLearningLeaders(){
        gadApi.getLearningLeaders()
            .enqueue(object : Callback<ArrayList<LearningItem>>{
                override fun onFailure(call: Call<ArrayList<LearningItem>>, t: Throwable) {
                    learningLiveData.value = null

                    Log.e("Learning-error",t.toString())
                }

                override fun onResponse(
                    call: Call<ArrayList<LearningItem>>,
                    response: Response<ArrayList<LearningItem>>) {

                    Log.e("Learning-ok",response.isSuccessful.toString())

                        if(response.isSuccessful){

                            learningLiveData.value = response.body()

                        }else{

                            learningLiveData.value = null
                        }

                }
            })
    }


    fun getSkillLeaders(){
        gadApi.getSkillIQLeaders()
            .enqueue(object : Callback<ArrayList<SkillItem>>{
                override fun onFailure(call: Call<ArrayList<SkillItem>>, t: Throwable) {
                    skillLiveData.value = null

                    Log.e("Skill-error",t.toString())
                }

                override fun onResponse(
                    call: Call<ArrayList<SkillItem>>,
                    response: Response<ArrayList<SkillItem>>) {

                    Log.e("Skill-ok",response.isSuccessful.toString())

                    if(response.isSuccessful){

                        skillLiveData.value = response.body()

                    }else{

                        skillLiveData.value = null
                    }

                }
            })
    }


    fun submit(email:String,name:String,lastName:String,link:String){

        gadApi.submit(email = email,name = name,lastName = lastName,link = link)
            .enqueue(object :Callback<Any?>{
                override fun onFailure(call: Call<Any?>, t: Throwable) {
                    submitLiveData.value = false

                    Log.e("submit-ok",t.toString())

                }

                override fun onResponse(call: Call<Any?>, response: Response<Any?>) {

                    submitLiveData.value = response.isSuccessful

                    Log.e("submit-ok",response.isSuccessful.toString())
                }
            })

    }
}