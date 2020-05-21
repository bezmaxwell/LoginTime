package com.example.logintime.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.logintime.R

class ChatFragment : Fragment() {

    private lateinit var dashboardViewModel: ChatViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dashboardViewModel = ViewModelProviders.of(this).get(ChatViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_chat, container, false)

       val button_dashboard:Button = root.findViewById(R.id.button_dashboard)

        button_dashboard.setOnClickListener {
            Toast.makeText(context,"O Botao foi clicado ",Toast.LENGTH_LONG).show()

        }

        return root
    }


    // criar noticias para interação com o usuário
    // uso de consumo de api
}
