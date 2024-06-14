package com.example.thirdles

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import androidx.core.widget.addTextChangedListener
import java.util.Random

class MainActivity : AppCompatActivity() {
    var number1 = 0
    var number2 = 0
    var amal = 0
    var javob = 0


    var foyKiritganJavob: Int? = 0

    lateinit var txt1: TextView
    lateinit var edt1: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt1 = findViewById(R.id.txt_1)
        edt1 = findViewById(R.id.edt_1)
        random()

        edt1.addTextChangedListener {
            if (edt1.text.isNotEmpty()) {
                foyKiritganJavob = edt1.text.toString().toInt()
                if (foyKiritganJavob.toString().length == javob.toString().length) {
                    if (foyKiritganJavob == javob) {
                        Toast.makeText(this, "To'g'ri", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Noto'g'ri", Toast.LENGTH_SHORT).show()
                    }
                    random()
                }
            }
        }
    }

    fun random() {
        number1 = Random().nextInt(10)
        number2 = Random().nextInt(20)

        amal = Random().nextInt(4)
        ekrangaChiqar()
    }

    @SuppressLint("SetTextI18n")
    fun ekrangaChiqar() {
        when (amal) {
            0 -> {
                javob = number1 + number2
                txt1.text = "$number1 + $number2= "
            }

            1 -> {
                javob = number1 - number2
                txt1.text = "$number1 - $number2= "
            }

            2 -> {

                javob = number1 * number2
                txt1.text = "$number1 * $number2= "
            }

            3 -> {
                try {

                    javob = number1 / number2
                    txt1.text = "$number1 / $number2= "
                } catch (e: Exception) {
                    random()
                }
            }
        }
    }
}