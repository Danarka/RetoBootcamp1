package com.bcp.proyectoreto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var button : Button
    lateinit var cardSpinner : Spinner
    lateinit var quotaSpinner : Spinner
    lateinit var teaSpinner : Spinner
    lateinit var paymentSpinner : Spinner
    lateinit var amount : TextView
    lateinit var dni : TextView
    lateinit var stringRequest: MainRequest



    var cards = arrayOf("Clásica", "Oro", "Black")
    var paymentDays = arrayOf(5, 20)
    var quotas = arrayOf(1, 6, 12, 18, 24, 30, 36)
    var teas = arrayOf(99.90, 95.90, 90.90)

    override fun onCreate(savedInstanceState: Bundle?) {
        stringRequest = MainRequest()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.btnSimulate)
        button.setOnClickListener(this)
        dni = findViewById(R.id.txtDni)
        amount = findViewById(R.id.txtAmount)

        //Tipo de tarjeta
        cardSpinner = findViewById(R.id.spinnerCard)
        if (cardSpinner != null) {
            val adapter = ArrayAdapter(this,
                    android.R.layout.simple_spinner_item, cards)
            cardSpinner.adapter = adapter
        }

        //Cuotas
        quotaSpinner = findViewById(R.id.spinnerQuotas)
        if (quotaSpinner != null) {
            val adapter = ArrayAdapter(this,
                    android.R.layout.simple_spinner_item, quotas)
            quotaSpinner.adapter = adapter
        }

        //Tea
        teaSpinner = findViewById(R.id.spinnerTea)
        if (teaSpinner != null) {
            val adapter = ArrayAdapter(this,
                    android.R.layout.simple_spinner_item, teas)
            teaSpinner.adapter = adapter
        }

        //Payment
        paymentSpinner = findViewById(R.id.spinnerPayment)
        if (paymentSpinner != null) {
            val adapter = ArrayAdapter(this,
                    android.R.layout.simple_spinner_item, paymentDays)
            paymentSpinner.adapter = adapter
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnSimulate->{
                createRequest()
                val intent = Intent(this, SummaryActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun createRequest() {
        stringRequest.dni = dni.text.toString()
        stringRequest.monto = amount.text.toString()
        stringRequest.tarjeta = cardSpinner.selectedItem.toString()
        stringRequest.diaPago = paymentSpinner.selectedItem.toString()
        stringRequest.cuota = quotaSpinner.selectedItem.toString()
        stringRequest.moneda = "S/"
        stringRequest.tea = teaSpinner.selectedItem.toString()
    }


}
