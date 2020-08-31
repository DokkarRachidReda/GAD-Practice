package com.reda_dokkar.gadproject.data.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.reda_dokkar.gadproject.data.model.LearningItem
import com.reda_dokkar.gadproject.data.model.SkillItem
import com.reda_dokkar.gadproject.data.repository.BaseRepository

class BaseVm : ViewModel() {

    private val repo = BaseRepository()

    fun getLearningLeaders(){
        repo.getLearningLeaders()
    }


    fun getSkillLeaders(){
        repo.getSkillLeaders()
    }

    fun getLearningLv():LiveData<ArrayList<LearningItem>>{return repo.learningLiveData}

    fun getSkillLv():LiveData<ArrayList<SkillItem>>{return repo.skillLiveData}
}