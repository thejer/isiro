package app.com.yorubacalc.ui.calculator

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.com.yorubacalc.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), View.OnClickListener {
    private var operandsOperatorStack = arrayListOf<String>()
    private var resultOutput = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        number_one.setOnClickListener(this)
        number_two.setOnClickListener(this)
        number_three.setOnClickListener(this)
        number_four.setOnClickListener(this)
        number_five.setOnClickListener(this)
        number_six.setOnClickListener(this)
        number_seven.setOnClickListener(this)
        number_eight.setOnClickListener(this)
        number_nine.setOnClickListener(this)
        number_zero.setOnClickListener(this)
        multiply.setOnClickListener(this)
        divide.setOnClickListener(this)
        plus.setOnClickListener(this)
        minus.setOnClickListener(this)
        equals.setOnClickListener(this)
        clear.setOnClickListener(this)
    }

    private fun updateOperands() {
        if (operandsOperatorStack.isEmpty()) {
            first_operand.text = " "
            first_operand_img.visibility = View.GONE
            operator.text = " "
            second_operand.text = " "
            second_operand_img.visibility = View.GONE
            return
        }
        if (operandsOperatorStack.size > 0) {
            val value = operandsOperatorStack[0]
            first_operand.text = getString(getNumber(value))
            if (value.toInt() in 1..10) {
                first_operand_img.apply {
                    visibility = View.VISIBLE
                    setImageResource(getNumberImage(value))
                }
            } else first_operand_img.visibility = View.GONE
        } else {
            first_operand.text = " "
            first_operand_img.visibility = View.GONE
        }
        if (operandsOperatorStack.size > 1)
            operator.text = getString(getNumber(operandsOperatorStack[1]))
        else operator.text = " "
        if (operandsOperatorStack.size > 2) {
            val value = operandsOperatorStack[2]
            second_operand.text = getString(getNumber(value))
            if (value.toInt() in 1..10) {
                second_operand_img.apply {
                    visibility = View.VISIBLE
                    setImageResource(getNumberImage(value))
                }
            } else second_operand_img.visibility = View.GONE
        } else {
            second_operand.text = " "
            second_operand_img.visibility = View.GONE
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
        "/" -> R.string.divide
        "x" -> R.string.multiply
        "+" -> R.string.plus
        else -> R.string.minus
    }

    private fun playSound(number: String) {
        val resId = resources.getIdentifier("i$number", "raw", context!!.packageName)
        val player = MediaPlayer.create(context, resId)
        player.start()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.number_one -> {
                if (operandsOperatorStack.size == 0 || operandsOperatorStack.size == 2) {
                    operandsOperatorStack.add("1")
                    playSound("1")
                    updateOperands()
                }
            }
            R.id.number_two -> {
                if (operandsOperatorStack.size == 0 || operandsOperatorStack.size == 2) {
                    operandsOperatorStack.add("2")
                    playSound("2")
                    updateOperands()
                }
            }
            R.id.number_three -> {
                if (operandsOperatorStack.size == 0 || operandsOperatorStack.size == 2) {
                    operandsOperatorStack.add("3")
                    playSound("3")
                    updateOperands()
                }
            }
            R.id.number_four -> {
                if (operandsOperatorStack.size == 0 || operandsOperatorStack.size == 2) {
                    operandsOperatorStack.add("4")
                    playSound("4")
                    updateOperands()
                }
            }
            R.id.number_five -> {
                if (operandsOperatorStack.size == 0 || operandsOperatorStack.size == 2) {
                    operandsOperatorStack.add("5")
                    playSound("5")
                    updateOperands()
                }
            }
            R.id.number_six -> {
                if (operandsOperatorStack.size == 0 || operandsOperatorStack.size == 2) {
                    playSound("6")
                    operandsOperatorStack.add("6")
                    updateOperands()
                }
            }
            R.id.number_seven -> {
                if (operandsOperatorStack.size == 0 || operandsOperatorStack.size == 2) {
                    operandsOperatorStack.add("7")
                    playSound("7")
                    updateOperands()
                }
            }
            R.id.number_eight -> {
                if (operandsOperatorStack.size == 0 || operandsOperatorStack.size == 2) {
                    operandsOperatorStack.add("8")
                    playSound("8")
                    updateOperands()
                }
            }
            R.id.number_nine -> {
                if (operandsOperatorStack.size == 0 || operandsOperatorStack.size == 2) {
                    playSound("9")
                    operandsOperatorStack.add("9")
                    updateOperands()
                }
            }
            R.id.number_zero -> {
                if (operandsOperatorStack.size == 0 || operandsOperatorStack.size == 2) {
                    operandsOperatorStack.add("0")
                    playSound("0")
                    updateOperands()
                }
            }
            R.id.clear -> if (operandsOperatorStack.isNotEmpty()) {
                d("HOME", "Clicked")
                result.text = ""
                result_img.visibility = View.GONE
                operandsOperatorStack.removeAt(operandsOperatorStack.size - 1)
                updateOperands()
            }
            R.id.equals -> {
                if (operandsOperatorStack.size == 3) {
                    val firstOperand = operandsOperatorStack[0].toInt()
                    val secondOperand = operandsOperatorStack[2].toInt()
                    val operator = operandsOperatorStack[1]
                    resultOutput = when (operator) {
                        "+" -> firstOperand + secondOperand
                        "-" -> firstOperand - secondOperand
                        "x" -> firstOperand * secondOperand
                        else -> firstOperand / secondOperand
                    }
                    if (resultOutput<0) return
                    val resId = resources.getIdentifier("ieq", "raw", context!!.packageName)
                    val player = MediaPlayer.create(context, resId)
                    player.start()
                    player.setOnCompletionListener {
                        playSound(resultOutput.toString())
                    }
                    if (resultOutput in 1..10) {
                        result_img.apply {
                            visibility = View.VISIBLE
                            setImageResource(getNumberImage(resultOutput.toString()))
                        }
                    } else result_img.visibility = View.GONE

                    if (resultOutput in 0..9) {
                        result.text = getString(getNumber(resultOutput.toString()))
                    } else {
                        getOtherNumbers(resultOutput.toString())
                    }
                }
            }
            R.id.plus -> {
                if (operandsOperatorStack.size == 1) {
                    operandsOperatorStack.add("+")
                    playSound("plus")
                    updateOperands()
                }
            }
            R.id.minus -> {
                if (operandsOperatorStack.size == 1) {
                    playSound("min")
                    operandsOperatorStack.add("-")
                    updateOperands()
                }
            }
            R.id.multiply -> {
                if (operandsOperatorStack.size == 1) {
                    playSound("x")
                    operandsOperatorStack.add("x")
                    updateOperands()
                }
            }
            R.id.divide -> {
                if (operandsOperatorStack.size == 1) {
                    operandsOperatorStack.add("/")
                    playSound("div")
                    updateOperands()
                }
            }
        }
    }

    private fun getOtherNumbers(number: String) {
        if (number.length == 1) return
        val firstDigit = number[0].toString()
        val secondDigit = number[1].toString()
        if (number.toInt() in 11..14) {
            val output = "${number}${getString(getNumber(secondDigit)).removeRange(0, 1)}lá"
            result.text = output
            return
        }
        if (secondDigit == "0") {
            result.text = getString(getNumber(number))
            return
        }
        if (secondDigit.toInt() in 5..9) {
            val secondNum = secondDigit.toInt()
            val suffixNumber = (firstDigit.toInt() * 10) + 10
            val prefixNumber = 10 - secondNum
            val prefix = getString(getNumber(prefixNumber.toString())).removeRange(0, 1)
            val suffix = getString(getNumber(suffixNumber.toString())).removeRange(0, 3)
            val output = "${number}${prefix}dinl'${suffix}"
            result.text = output
            return
        }
        if (secondDigit.toInt() in 1..4) {
            val suffixNumber = (firstDigit.toInt() * 10)
            val prefix = getString(getNumber(secondDigit)).removeRange(0, 1)
            val suffix = getString(getNumber(suffixNumber.toString())).removeRange(0, 3)
            val output = "${number}${prefix}lel${suffix}"
            result.text = output
        }
    }
}