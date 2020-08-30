package app.com.yorubacalc.ui.images


import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import app.com.yorubacalc.R
import app.com.yorubacalc.ui.ImagesObject
import kotlinx.android.synthetic.main.fragment_images.*

/**
 * A simple [Fragment] subclass.
 */
class ImagesFragment : Fragment() {
    private lateinit var imagesAdapter: ImagesRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_images, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        imagesAdapter.swapItems(generateTextAndImages())
    }

    private fun generateTextAndImages(): MutableList<ImagesObject> {
        val imageObjects = mutableListOf<ImagesObject>()
        for (i in 1..100) {
            imageObjects.add(ImagesObject(getNumbers("$i"), getImages("$i")))
        }
        return imageObjects
    }

    private fun setupRecyclerView() {
        imagesAdapter = ImagesRecyclerViewAdapter()
        val decoration = DividerItemDecoration(context!!, DividerItemDecoration.VERTICAL)
        images_recyclerView.apply {
            adapter = imagesAdapter
            addItemDecoration(decoration)
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }
    }


    private fun getNumberImage(value: String): Int = when (value) {
        "1" -> R.drawable.one
        "2" -> R.drawable.two
        "3" -> R.drawable.three
        "4" -> R.drawable.four
        "5" -> R.drawable.five
        "6" -> R.drawable.six
        "7" -> R.drawable.seven
        "8" -> R.drawable.eight
        "9" -> R.drawable.nine
        else -> R.drawable.ten
    }


    private fun getImages(number: String): MutableList<Int> {
        when {
            number.length == 1 -> {
                val images = mutableListOf<Int>()
                images.add(0, getNumberImage(number))
                return images
            }
            number == "100" -> {
                val images = mutableListOf<Int>()
                for (i in 1..10) {
                    images.add(getNumberImage("10"))
                }
                return images
            }
            else -> {
                val firstDigit = number[0].toString()
                val secondDigit = number[1].toString()
                val images = mutableListOf<Int>()
                for (i in 1..firstDigit.toInt()) {
                    images.add(getNumberImage("10"))
                }
                if (secondDigit != "0")
                    images.add(getNumberImage(secondDigit))
                return  images
            }
        }
    }

    private fun getNumber(value: String): Int = when (value) {
        "1" -> R.string.number_one
        "2" -> R.string.number_two
        "3" -> R.string.number_three
        "4" -> R.string.number_four
        "5" -> R.string.number_five
        "6" -> R.string.number_six
        "7" -> R.string.number_seven
        "8" -> R.string.number_eight
        "9" -> R.string.number_nine
        "0" -> R.string.number_zero
        "10" -> R.string.ten
        "20" -> R.string.twenty
        "30" -> R.string.thirty
        "40" -> R.string.forty
        "50" -> R.string.fifty
        "60" -> R.string.sixty
        "70" -> R.string.seventy
        "80" -> R.string.eighty
        "90" -> R.string.ninety
        "100" -> R.string.one_hundred
        else -> R.string.minus
    }

    private fun getNumbers(number: String): String {
        if (number.length == 1) {
            return getString(getNumber(number)).replaceFirst("\n", ": ")
        } else {
            val firstDigit = number[0].toString()
            val secondDigit = number[1].toString()
            if (number.toInt() in 11..14) {
                return "${number}${getString(getNumber(secondDigit))
                    .removeRange(0, 1)}lá".replaceFirst("\n", ": ")
            }
            if (secondDigit == "0") {
                return getString(getNumber(number)).replaceFirst("\n", ": ")
            }
            if (secondDigit.toInt() in 5..9) {
                val secondNum = secondDigit.toInt()
                val suffixNumber = (firstDigit.toInt() * 10) + 10
                val prefixNumber = 10 - secondNum
                val prefix = getString(getNumber(prefixNumber.toString())).removeRange(0, 1)
                val suffix = getString(getNumber(suffixNumber.toString())).removeRange(0, 3).replaceFirst("\n", "")
                return "${number}${prefix}dinl'${suffix}".replaceFirst("\n", ": ")
            }
            if (secondDigit.toInt() in 1..4) {
                val suffixNumber = (firstDigit.toInt() * 10)
                val prefix = getString(getNumber(secondDigit)).removeRange(0, 1)
                val suffix = getString(getNumber(suffixNumber.toString())).removeRange(0, 3)
                return "${number}${prefix}lel${suffix}".replaceFirst("\n", ": ")
            }
        }
        return ""
    }

}
