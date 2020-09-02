package com.reda_dokkar.gadproject.data.viewModel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.reda_dokkar.gadproject.data.repository.BaseRepository

class SubmitVm : ViewModel() {

    val repo = BaseRepository()

    fun submit(email:String,name:String,lastName:String,link:String){

    if(Patterns.EMAIL_ADDRESS.matcher(email).matches() // validate email
        && Patterns.WEB_URL.matcher(link).matches()   //  validate url
        && link.contains("github")             //   check if it's a github url
    ){

        repo.submit(email, name, lastName, link)

    }else{

        repo.submitLiveData.value = false
    }

    }


    fun getSubmitLv():LiveData<Boolean>{return repo.submitLiveData}
}