package app.com.yorubacalc.ui.sound


import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import app.com.yorubacalc.R
import kotlinx.android.synthetic.main.fragment_sound.*

/**
 * A simple [Fragment] subclass.
 */
class SoundFragment : Fragment(), SoundRecyclerViewAdapter.OnItemClickListener {
    private var buffer = ArrayList<MediaPlayer>()
    private lateinit var player: MediaPlayer

    private lateinit var soundsAdapter: SoundRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sound, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        val numbers = mutableListOf<String>()
        for (i in 1..100) {
            numbers.add(getNumbers("$i"))
        }
        soundsAdapter.swapItems(numbers)
    }

    private fun setupRecyclerView() {
        soundsAdapter = SoundRecyclerViewAdapter(this)
        val decoration = DividerItemDecoration(context!!, DividerItemDecoration.VERTICAL)
        sounds_recyclerView.apply {
            adapter = soundsAdapter
            addItemDecoration(decoration)
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }
    }

    private fun playSound(number: String) {
        val resId = resources.getIdentifier("i$number", "raw", context!!.packageName)
        val player = MediaPlayer.create(context, resId)
        player.start()
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
                val suffix = getString(getNumber(suffixNumber.toString())).removeRange(0, 3)
                    .replaceFirst("\n", "")
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

    private fun addInitFile(res: Int) {
        val mediaPlayer = MediaPlayer.create(context, res)
        buffer.add(mediaPlayer)
        player = buffer[0]
        player.start()
        player.setOnCompletionListener {
            val index = buffer.indexOf(mediaPlayer)
            if (buffer.size - 1 > index) {
                player = buffer[index + 1]
                player.start()
            }
        }
    }

    private fun addFile(res: Int) {
        val mp = MediaPlayer.create(context, res)
        mp.setOnCompletionListener {
            val index = buffer.indexOf(mp)
            if (buffer.size - 1 > index) {
                player = buffer[index + 1]
                player.start()
            }
        }
        buffer.add(mp)
    }

    override fun onItemClicked(position: Int) {
        playSound((position + 1).toString())
    }


}
