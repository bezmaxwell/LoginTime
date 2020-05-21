package com.example.logintime.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.logintime.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        handleLogin()
    }


  private fun handleLogin() {

        val email = activity_email_Login.toString()
        val password = activity_password_Login.toString()

        val btn_Login = findViewById<Button>(R.id.activity_button_Login)
        val btn_reset = findViewById<Button>(R.id.activity_button_reset_Login)
        val btn_register = findViewById<Button>(R.id.activity_button_create_Login)

        // redirecionar para a verificação em seguida para o banco de dados

        btn_Login.setOnClickListener {

            //fazer verificacao de login
            if (email.isEmpty() || password.isEmpty() || password.length < 8) {
                Toast.makeText(this, "Verifique os dados corretamente antes de continuar !!! ", Toast.LENGTH_LONG).show()

            } else {
                // firebase parâmetros
                val user = auth.currentUser
                updateUI(user)  //retirar update e validar login
               // validateSignInWithEmailandPassword(email, password)

            }
        }

        btn_reset.setOnClickListener {
            activity_email_Login.setText("")
            activity_password_Login.setText("")

        }

        btn_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

  private  fun validateSignInWithEmailandPassword(email:String ,password: String) {

      auth.signInWithEmailAndPassword(email, password)
          .addOnCompleteListener {

           if  (it.isSuccessful) {
               val user = auth.currentUser
               updateUI(user)
          } else {updateUI(null) }
          }


  }


    private fun updateUI(user: FirebaseUser?) {

        if(user!=null) {
            //abrir o main activity
            Toast.makeText(this, "Login com sucesso", Toast.LENGTH_LONG).show()
               val intent = Intent(this,MainLoginActivity::class.java)
               startActivity(intent)
              finish()

        }else {
            Toast.makeText(this, "Email ou password estão incorretos !!! ", Toast.LENGTH_LONG).show()
        }
    }

}


