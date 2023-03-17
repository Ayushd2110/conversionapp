package com.ayush.conversionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var edInputText: EditText? = null
    private var spMeasure: Spinner? = null
    private var count = 0
    private var ca: Conversion? = null
    private var tvAns: TextView? = null
    var stValue = "0"
    var arrMeasure = arrayOf(
        "Kilometre to Miles",
        "Miles to Kilometre",
        "Centimetre to Inch",
        "Inch to Centimetre",
        "Kilogram to Pound",
        "Pound to Kilogram",
        "Gram to Ounce",
        "Gram to Ounce",
        "Celsius to Fahrenheit",
        "Celsius to Kelvin",
        "Fahrenheit to Celsius",
        "Kelvin to Celsius",
        " Litre to Cups",
        "Cups to Litre"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindID()
        val stringArrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item, arrMeasure
        )
        spMeasure!!.setAdapter(stringArrayAdapter)
        ca = Conversion()
    }

    fun bindID() {
        edInputText = findViewById<View>(R.id.edInputText) as EditText?
        spMeasure = findViewById<View>(R.id.spMeasure) as Spinner?
        tvAns = findViewById<View>(R.id.tvAns) as TextView?
    }
    fun onClick(v: View) {
        when (v.id) {


            R.id.btnZero -> edInputText!!.setText(edInputText!!.text.toString() + "0")
            R.id.btnOne -> edInputText!!.setText(edInputText!!.text.toString() + "1")
            R.id.btnTwo -> edInputText!!.setText(edInputText!!.text.toString() + "2")
            R.id.btnThree -> edInputText!!.setText(edInputText!!.text.toString() +"3")
            R.id.btnFour -> edInputText!!.setText(edInputText!!.text.toString() + "4")
            R.id.btnFive -> edInputText!!.setText(edInputText!!.text.toString() + "5")
            R.id.btnSix -> edInputText!!.setText(edInputText!!.text.toString() +"6")
            R.id.btnSeven -> edInputText!!.setText(edInputText!!.text.toString() + "7")
            R.id.btnEight -> edInputText!!.setText(edInputText!!.text.toString() + "8")
            R.id.btnNine -> edInputText!!.setText(edInputText!!.text.toString() + "9")
            R.id.btnDecimal -> if (count == 0) {
                edInputText!!.setText(edInputText!!.text.toString() + ".")
                count++
            }
            R.id.btnClear -> {
                edInputText!!.setText("")
                count = 0
                stValue = "0"
            }
        R.id.btnEquals -> {
                val spPosition: Int = spMeasure!!.getSelectedItemPosition()
                stValue = edInputText!!.text.toString()
                try {
                    val dbNumber = stValue.toDouble()
                    val result = evaluate(spPosition, dbNumber)
                    tvAns!!.setText("Conversion is $result")
                } catch (e: Exception) {
                    tvAns!!.setText("Your Conversion is 0")
                }
            }
        }
    }

    fun evaluate(spPosition: Int, dbNumber: Double): Double {
        var dbAns = 0.0
        when (spPosition) {
            0 ->                 // convert from Kilometre to Miles
                dbAns = ca!!.kmToml(dbNumber)
            1 ->                 // convert from Miles to Kilometre
                dbAns = ca!!.mlTOkm(dbNumber)
            2 ->                 // convert from Centimetre to Inch
                dbAns = ca!!.cmToin(dbNumber)
            3 ->                 // convert from Inch to Centimetre
                dbAns = ca!!.inTOcm(dbNumber)
            4 ->                 // convert from Kilogram to Pound
                dbAns = ca!!.kgTopo(dbNumber)
            5 ->                 // convert from Pound to Kilogram
                dbAns = ca!!.poTokg(dbNumber)
            6 ->                 // convert from Gram to Ounce
                dbAns = ca!!.grToou(dbNumber)
            7 ->                 // convert from Ounce to Gram
                dbAns = ca!!.ouTogr(dbNumber)
            8 ->                 // convert from Celsius to Fahrenheit
                dbAns = ca!!.ceTofa(dbNumber)
            9 ->                 // convert from Celsius to Kelvin
                dbAns = ca!!.ceToke(dbNumber)
            10 ->                 // convert from Fahrenheit to Celsius
                dbAns = ca!!.faToce(dbNumber)
            11 ->                 // convert from Kelvin to Celsius
                dbAns = ca!!.keToce(dbNumber)
            12 ->                 // convert from Litre to Cups
                dbAns = ca!!.ltTocu(dbNumber)
            13 ->                 // convert from Cups to Litre
                dbAns = ca!!.cuTolt(dbNumber)
        }
        return dbAns
    }
}