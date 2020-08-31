package com.reda_dokkar.gadproject.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.reda_dokkar.gadproject.R
import com.reda_dokkar.gadproject.ui.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

            if(position == 0){
                tab.text = "Learning Leaders"

            }else{
                tab.text = "Skill IQ Leaders"
            }
        }.attach()
    }

    fun toSubmit(view: View) {

        startActivity(Intent(this,SubmitActivity::class.java))

    }
}