package com.example.logintime.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.logintime.R
import com.example.logintime.controller.RegisterController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

open class RegisterActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var registerSpinner: RegisterController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        handleSave()

    }


    private fun handleSave() {
        // adicionar spinner da classe Register Controller


        val btn_timer_register = register_timer_btn
        val btn_backLogin = loginBack_Register_btn

        btn_timer_register.setOnClickListener { saveRegister() }

        btn_backLogin.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    private fun saveRegister() {
        // fazer a verificação do uso do email e do nome
        // salvar dados no banco de dados firebase


        val login_register = register_name_activity.text.toString()
        val register_register = register_email_activity.text.toString()
        val password_register = register_password_activity.text.toString()
        val pos = register_spinnerCity_activity.selectedItemPosition


        if (login_register.isEmpty() || register_register.isEmpty() || password_register.isEmpty() || password_register.length < 8 || pos == 0) {

            Toast.makeText(this, "Por favor , Complete os dados corretamente", Toast.LENGTH_LONG)
                .show()
        } else {

           createUserWithEmailandPassword(register_register,password_register)
        }
    }

   private fun createUserWithEmailandPassword(email: String, password: String) {

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    openLoginActivity()

                } else {
                    Toast.makeText(this, "Faillure on Register", Toast.LENGTH_SHORT).show()
                }
            }
        }


    private fun openLoginActivity() {

        Toast.makeText(this,"Voce foi registrado com sucesso !!! ", Toast.LENGTH_LONG).show()
         val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
         finish()
    }
}
