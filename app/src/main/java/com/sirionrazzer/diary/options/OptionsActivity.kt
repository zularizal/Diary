package com.sirionrazzer.diary.options

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.sirionrazzer.diary.R
import kotlinx.android.synthetic.main.activity_history.*

import kotlinx.android.synthetic.main.activity_options.*
import kotlinx.android.synthetic.main.toolbar.*

class OptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)
        setSupportActionBar(toolbar)

//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        supportActionBar!!.setDisplayShowHomeEnabled(true)


    }

}
