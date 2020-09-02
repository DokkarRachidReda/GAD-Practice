package com.reda_dokkar.gadproject.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.reda_dokkar.gadproject.R
import com.reda_dokkar.gadproject.data.model.Item
import com.reda_dokkar.gadproject.data.model.LearningItem
import com.reda_dokkar.gadproject.data.model.SkillItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_list_item.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>{

    private var list:ArrayList<Item>
    private val context:Context
    private val selection:Int

    var lastIndex = 0

    constructor(list:ArrayList<Item>,context: Context,selection:Int){
        this.list = list
        this.context = context
        this.selection = selection
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img : ImageView    = itemView.row_img
        val title : TextView   = itemView.row_title
        val content : TextView = itemView.row_content
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.row_list_item,null)


        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {



        holder.title.text = list[position].name

        Picasso.get().load(list[position].badgeUrl).into(holder.img)

        if(selection == 0){ // learning leaders

            val item : LearningItem =  list[position] as LearningItem

            holder.content.text = "${item.hours} learning hours,${item.country}"

        }else{ // skill iq leaders

            val item : SkillItem =  list[position] as SkillItem

            holder.content.text = "${item.score} Skill IQ Score,${item.country}"

        }


        if(position > lastIndex){
            val anim = AnimationUtils.loadAnimation(context,R.anim.top_to_bottom)
            holder.itemView.startAnimation(anim)
        }else{
            val anim = AnimationUtils.loadAnimation(context,R.anim.bottom_to_top)
            holder.itemView.startAnimation(anim)
        }

        lastIndex = position

    }


     fun updateList(newList: ArrayList<Item>){
        this.list = newList

        notifyDataSetChanged()
    }
}