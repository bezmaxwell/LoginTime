package com.example.logintime.ui.calculator

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.logintime.R
import com.example.logintime.views.MainLoginActivity
import kotlinx.android.synthetic.main.calculator_fragment.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class CalculatorFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.calculator_fragment, container, false)
        root.setOnClickListener { calculatorSave() }
        return root
    }

    fun calculatorSave() {
        calculator_btn_ArquiveResult_Main.setOnClickListener {
            //arquivar o resultado e mostrar atraves de um text view onde pode ser assimilado ou deletado

        }

        calculator_btn_backMain.setOnClickListener {
            // volta para o menu principal
            val intent = Intent(context, MainLoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        val b0 = calculator_button_0
        val b1 = calculator_button_1
        val b2 = calculator_button_2
        val b3 = calculator_button_3
        val b4 = calculator_button_4
        val b5 = calculator_button_5
        val b6 = calculator_button_6
        val b7 = calculator_button_7
        val b8 = calculator_button_8
        val b9 = calculator_button_9
        val multiply = calculator_button_multiply
        val divided = calculator_button_divided
        val plus = calculator_button_plus
        val minus = calculator_button_minus
        val equacao = calculator_text_result
        val resultado = calculator_text_lastReso
        val equalsCalcular = calculator_button_equals
        val resetCal = calculator_button_reset

        fun appendOnExpression(string: String, canClear: Boolean) {
            if (canClear) {
                resultado.text = ""
                equacao.append(string)
            } else {
                equacao.append(resultado.text)
                equacao.append(string)
                resultado.text = ""
            }
        }




        resetCal.setOnClickListener {
            equacao.setText("")
            resultado.setText("")
        }

        b0.setOnClickListener { appendOnExpression("0", true) }
        b1.setOnClickListener { appendOnExpression("1", true) }
        b2.setOnClickListener { appendOnExpression("2", true) }
        b3.setOnClickListener { appendOnExpression("3", true) }
        b4.setOnClickListener { appendOnExpression("4", true) }
        b5.setOnClickListener { appendOnExpression("5", true) }
        b6.setOnClickListener { appendOnExpression("6", true) }
        b7.setOnClickListener { appendOnExpression("7", true) }
        b8.setOnClickListener { appendOnExpression("8", true) }
        b9.setOnClickListener { appendOnExpression("9", true) }

        multiply.setOnClickListener { appendOnExpression("x", false) }

        divided.setOnClickListener { appendOnExpression("/", false) }

        plus.setOnClickListener { appendOnExpression("+", false) }

        minus.setOnClickListener { appendOnExpression("-", false) }


        calculator_button_excludeValues.setOnClickListener {
            val string = resultado.text.toString()
            if (string.isNotEmpty()) {

                equacao.text = string.substring(0, string.length - 1)
            }

            resultado.text = ""
        }


        // consertar codigo quando clicado em equals resolve a equação
        equalsCalcular.setOnClickListener {
            try {
                val expression = ExpressionBuilder(equacao.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()

                if (result == longResult.toDouble())
                    resultado.text = longResult.toString()
                else
                    resultado.text = result.toString()

            } catch (e: Exception) {

                Toast.makeText(context, "Message " + e.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}