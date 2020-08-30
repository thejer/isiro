package app.com.yorubacalc.ui.images

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.com.yorubacalc.R
import app.com.yorubacalc.ui.ImagesObject
import kotlinx.android.synthetic.main.number_image_item.view.*


class ImagesRecyclerViewAdapter :
    RecyclerView.Adapter<ImagesRecyclerViewAdapter.ImagesViewHolder>() {

    private var imageObjects = mutableListOf<ImagesObject>()

    class ImagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            model: ImagesObject
        ) {
            itemView.number_text.text = model.text
            val images = model.images
//            for (i in 1..images.size) {
//                //                d("ImagesRecycler", "${model.text.take(2)}")
////                d("ImagesRecycler", "${images[i-1]}")
//
//                val resId = itemView.context.resources.getIdentifier("image$i", "id", itemView.context.packageName)
//                val imageView = itemView.findViewById<ImageView>(resId)
//                imageView.setImageResource(images[i-1])
//                images.removeAt(i-1)
//            }

            d("ImagesRecycler", images.size.toString())
            when (images.size) {
                1 -> {
                    itemView.image1.setImageResource(images[0])
                    itemView.image1.visibility=View.VISIBLE
                    itemView.image2.visibility=View.GONE
                    itemView.image3.visibility=View.GONE
                    itemView.image4.visibility=View.GONE
                    itemView.image5.visibility=View.GONE
                    itemView.image6.visibility=View.GONE
                    itemView.image7.visibility=View.GONE
                    itemView.image8.visibility=View.GONE
                    itemView.image9.visibility=View.GONE
                    itemView.image10.visibility=View.GONE
                }
                2 -> {
                    itemView.image1.setImageResource(images[0])
                    itemView.image2.setImageResource(images[1])
                    itemView.image1.visibility=View.VISIBLE
                    itemView.image2.visibility=View.VISIBLE
                    itemView.image3.visibility=View.GONE
                    itemView.image4.visibility=View.GONE
                    itemView.image5.visibility=View.GONE
                    itemView.image6.visibility=View.GONE
                    itemView.image7.visibility=View.GONE
                    itemView.image8.visibility=View.GONE
                    itemView.image9.visibility=View.GONE
                    itemView.image10.visibility=View.GONE
                }
                3 -> {
                    itemView.image1.setImageResource(images[0])
                    itemView.image2.setImageResource(images[1])
                    itemView.image3.setImageResource(images[2])
                    itemView.image1.visibility=View.VISIBLE
                    itemView.image2.visibility=View.VISIBLE
                    itemView.image3.visibility=View.VISIBLE
                    itemView.image4.visibility=View.GONE
                    itemView.image5.visibility=View.GONE
                    itemView.image6.visibility=View.GONE
                    itemView.image7.visibility=View.GONE
                    itemView.image8.visibility=View.GONE
                    itemView.image9.visibility=View.GONE
                    itemView.image10.visibility=View.GONE
                }
                4 -> {
                    itemView.image1.setImageResource(images[0])
                    itemView.image2.setImageResource(images[1])
                    itemView.image3.setImageResource(images[2])
                    itemView.image4.setImageResource(images[3])
                    itemView.image1.visibility=View.VISIBLE
                    itemView.image2.visibility=View.VISIBLE
                    itemView.image3.visibility=View.VISIBLE
                    itemView.image4.visibility=View.VISIBLE
                    itemView.image5.visibility=View.GONE
                    itemView.image6.visibility=View.GONE
                    itemView.image7.visibility=View.GONE
                    itemView.image8.visibility=View.GONE
                    itemView.image9.visibility=View.GONE
                    itemView.image10.visibility=View.GONE
                }
                5 -> {
                    itemView.image1.setImageResource(images[0])
                    itemView.image2.setImageResource(images[1])
                    itemView.image3.setImageResource(images[2])
                    itemView.image4.setImageResource(images[3])
                    itemView.image5.setImageResource(images[4])
                    itemView.image1.visibility=View.VISIBLE
                    itemView.image2.visibility=View.VISIBLE
                    itemView.image3.visibility=View.VISIBLE
                    itemView.image4.visibility=View.VISIBLE
                    itemView.image5.visibility=View.VISIBLE
                    itemView.image6.visibility=View.GONE
                    itemView.image7.visibility=View.GONE
                    itemView.image8.visibility=View.GONE
                    itemView.image9.visibility=View.GONE
                    itemView.image10.visibility=View.GONE
                }
                6 -> {
                    itemView.image1.setImageResource(images[0])
                    itemView.image2.setImageResource(images[1])
                    itemView.image3.setImageResource(images[2])
                    itemView.image4.setImageResource(images[3])
                    itemView.image5.setImageResource(images[4])
                    itemView.image6.setImageResource(images[5])
                    itemView.image1.visibility=View.VISIBLE
                    itemView.image2.visibility=View.VISIBLE
                    itemView.image3.visibility=View.VISIBLE
                    itemView.image4.visibility=View.VISIBLE
                    itemView.image5.visibility=View.VISIBLE
                    itemView.image6.visibility=View.VISIBLE
                    itemView.image7.visibility=View.GONE
                    itemView.image8.visibility=View.GONE
                    itemView.image9.visibility=View.GONE
                    itemView.image10.visibility=View.GONE

                }
                7 -> {
                    itemView.image1.setImageResource(images[0])
                    itemView.image2.setImageResource(images[1])
                    itemView.image3.setImageResource(images[2])
                    itemView.image4.setImageResource(images[3])
                    itemView.image5.setImageResource(images[4])
                    itemView.image6.setImageResource(images[5])
                    itemView.image7.setImageResource(images[6])
                    itemView.image1.visibility=View.VISIBLE
                    itemView.image2.visibility=View.VISIBLE
                    itemView.image3.visibility=View.VISIBLE
                    itemView.image4.visibility=View.VISIBLE
                    itemView.image5.visibility=View.VISIBLE
                    itemView.image6.visibility=View.VISIBLE
                    itemView.image7.visibility=View.VISIBLE
                    itemView.image8.visibility=View.GONE
                    itemView.image9.visibility=View.GONE
                    itemView.image10.visibility=View.GONE
                }
                8 -> {
                    itemView.image1.setImageResource(images[0])
                    itemView.image2.setImageResource(images[1])
                    itemView.image3.setImageResource(images[2])
                    itemView.image4.setImageResource(images[3])
                    itemView.image5.setImageResource(images[4])
                    itemView.image6.setImageResource(images[5])
                    itemView.image7.setImageResource(images[6])
                    itemView.image8.setImageResource(images[7])
                    itemView.image1.visibility=View.VISIBLE
                    itemView.image2.visibility=View.VISIBLE
                    itemView.image3.visibility=View.VISIBLE
                    itemView.image4.visibility=View.VISIBLE
                    itemView.image5.visibility=View.VISIBLE
                    itemView.image6.visibility=View.VISIBLE
                    itemView.image7.visibility=View.VISIBLE
                    itemView.image8.visibility=View.VISIBLE
                    itemView.image9.visibility=View.GONE
                    itemView.image10.visibility=View.GONE
                }
                9 -> {
                    itemView.image1.setImageResource(images[0])
                    itemView.image2.setImageResource(images[1])
                    itemView.image3.setImageResource(images[2])
                    itemView.image4.setImageResource(images[3])
                    itemView.image5.setImageResource(images[4])
                    itemView.image6.setImageResource(images[5])
                    itemView.image7.setImageResource(images[6])
                    itemView.image8.setImageResource(images[7])
                    itemView.image9.setImageResource(images[8])
                    itemView.image1.visibility=View.VISIBLE
                    itemView.image2.visibility=View.VISIBLE
                    itemView.image3.visibility=View.VISIBLE
                    itemView.image4.visibility=View.VISIBLE
                    itemView.image5.visibility=View.VISIBLE
                    itemView.image6.visibility=View.VISIBLE
                    itemView.image7.visibility=View.VISIBLE
                    itemView.image8.visibility=View.VISIBLE
                    itemView.image9.visibility=View.VISIBLE
                    itemView.image10.visibility=View.GONE
                }
                10 -> {
                    itemView.image1.setImageResource(images[0])
                    itemView.image2.setImageResource(images[1])
                    itemView.image3.setImageResource(images[2])
                    itemView.image4.setImageResource(images[3])
                    itemView.image5.setImageResource(images[4])
                    itemView.image6.setImageResource(images[5])
                    itemView.image7.setImageResource(images[6])
                    itemView.image8.setImageResource(images[7])
                    itemView.image9.setImageResource(images[8])
                    itemView.image10.setImageResource(images[9])
                    itemView.image1.visibility=View.VISIBLE
                    itemView.image2.visibility=View.VISIBLE
                    itemView.image3.visibility=View.VISIBLE
                    itemView.image4.visibility=View.VISIBLE
                    itemView.image5.visibility=View.VISIBLE
                    itemView.image6.visibility=View.VISIBLE
                    itemView.image7.visibility=View.VISIBLE
                    itemView.image8.visibility=View.VISIBLE
                    itemView.image9.visibility=View.VISIBLE
                    itemView.image10.visibility=View.VISIBLE
                }
            }
        }
    }

    fun swapItems(imageObjects: MutableList<ImagesObject>) {
        this.imageObjects = imageObjects
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        return ImagesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.number_image_item,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return imageObjects.size
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(imageObjects[position])
    }
}