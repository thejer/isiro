package app.com.yorubacalc.ui.sound

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.com.yorubacalc.R
import app.com.yorubacalc.ui.SoundObject
import kotlinx.android.synthetic.main.number_image_item.view.*
import kotlinx.android.synthetic.main.sound_item.view.*


class SoundRecyclerViewAdapter(
    private val onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<SoundRecyclerViewAdapter.SoundViewHolder>() {

    private var soundObjects = mutableListOf<String>()

    class SoundViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            model: String,
            listener: OnItemClickListener
        ) {
            itemView.sound_number_text.text = model
            itemView.setOnClickListener {
                listener.onItemClicked(layoutPosition)
            }
        }
    }

    fun swapItems(soundObjects: MutableList<String>) {
        this.soundObjects = soundObjects
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundViewHolder {
        return SoundViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.sound_item,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return soundObjects.size
    }

    override fun onBindViewHolder(holder: SoundViewHolder, position: Int) {
        holder.bind(soundObjects[position], onItemClickListener)
    }

    interface OnItemClickListener {
        fun onItemClicked(position: Int)
    }
}