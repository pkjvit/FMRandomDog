package com.pkj.learn.fmrandomdog.ui.recentsdog

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pkj.learn.fmrandomdog.R
import kotlinx.android.synthetic.main.layout_item_recent_dog.view.*

/**
 * @author Pankaj Jangid
 */
class RecentDogsAdapter: ListAdapter<String, DogViewHolder>(DogItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_item_recent_dog, parent, false))
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(url: String){
        Glide
            .with(itemView.context)
            .load(url)
            .into(itemView.image)
    }

}

class DogItemDiffCallback : ItemCallback<String>(){
    override fun areItemsTheSame(oldItem: String,
                                 newItem: String): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: String,
                                    newItem: String): Boolean = oldItem == newItem

}

class DogItemsDecoration(context: Context?, orientation: Int) :
    DividerItemDecoration(context, orientation) {

    private val offset = 10

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(offset, offset, offset, offset)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
    }
}
