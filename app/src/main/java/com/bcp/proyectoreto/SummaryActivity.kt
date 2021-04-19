package com.bcp.proyectoreto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SummaryActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        button = findViewById(R.id.btnReturn)
        button.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnReturn->{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}