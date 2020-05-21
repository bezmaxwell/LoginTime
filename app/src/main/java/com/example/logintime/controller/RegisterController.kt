package com.example.logintime.controller

import android.R
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.logintime.views.RegisterActivity
import kotlinx.android.synthetic.main.activity_register.*

lateinit var mR: RegisterActivity

class RegisterController {


    fun spinnerData() {
        // Acredito ser parte da -- CONTROLLER --
        // criar uma lista de array com values
        //criar valor no banco de dados
        // mandar para o banco de dados

        val cityName = arrayOf("", "Regiao", "Regiao1", "Regiao2", "Regiao3")
        val arrayAdapter = ArrayAdapter(RegisterActivity(), R.layout.simple_spinner_item, cityName)

        mR.register_spinnerCity_activity.adapter = arrayAdapter

        mR.register_spinnerCity_activity.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // posicao do item no spinner

            }

        }

    }

     fun dataButtonRegiter() {


    }

}