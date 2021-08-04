package com.proway.listainterfaceevents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.proway.listainterfaceevents.model.User
import com.proway.listainterfaceevents.singleton.Session

class LoginActivity : AppCompatActivity(), TextWatcher {

    private lateinit var inputCpf: EditText
    private lateinit var inputPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        carregarElementosDaTela()
    }

    fun carregarElementosDaTela() {
        inputCpf = findViewById(R.id.inputCpf)
        inputPassword = findViewById(R.id.inputPassword)
        buttonLogin = findViewById(R.id.buttonLogin)


//        inputCpf.addTextChangedListener(this)
        buttonLogin.setOnClickListener {
            if (validarCamposParaLogin()) {
                fazerLogin()
            } else {
                inputCpf.error = "CPF inválido"
                inputPassword.error = "Senha inválida"
            }
        }
    }

    private fun validarCamposParaLogin(): Boolean {
        val cpf = inputCpf.text.toString()
        val password = inputPassword.text.toString()
        if (cpf.isNotEmpty() && password.isNotEmpty()) {
            Session.currentUser = User(cpf, password)
            return Session.currentUser!!.isValidCpf() && Session.currentUser!!.isValidPassword()

        }
        return false

    }

    private fun fazerLogin() {
        Intent(this, MainActivity::class.java).apply {
            startActivity(this)
        }
    }


    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
    }
}