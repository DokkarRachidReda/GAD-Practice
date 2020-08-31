package com.reda_dokkar.gadproject.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.reda_dokkar.gadproject.R
import com.reda_dokkar.gadproject.data.model.Item
import com.reda_dokkar.gadproject.data.model.LearningItem
import com.reda_dokkar.gadproject.data.model.SkillItem
import com.reda_dokkar.gadproject.data.viewModel.BaseVm
import com.reda_dokkar.gadproject.ui.adapter.ListAdapter
import com.reda_dokkar.gadproject.ui.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment{
    private var selection = 0 // 0: top learners , 1 : top iq

    constructor(selection:Int){
        this.selection = selection
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)


        val mAdapter = ListAdapter(ArrayList(),activity!!,selection)


        view.mRecycler.apply {

            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
            adapter = mAdapter
        }

        val baseVm  = ViewModelProvider(this).get(BaseVm::class.java)

        if (selection == 0) baseVm.getLearningLeaders() else baseVm.getSkillLeaders()

        if (selection == 0){

            baseVm.getLearningLv().observe(viewLifecycleOwner,
                Observer<ArrayList<LearningItem>> { t -> mAdapter.updateList(t as ArrayList<Item>) })

        }else{

            baseVm.getSkillLv().observe(viewLifecycleOwner,
                Observer<ArrayList<SkillItem>> { t -> mAdapter.updateList(t as ArrayList<Item>) })

        }


        return view
    }




}