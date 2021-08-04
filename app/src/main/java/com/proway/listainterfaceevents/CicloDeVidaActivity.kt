package com.proway.listainterfaceevents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.proway.listainterfaceevents.R
import com.proway.listainterfaceevents.singleton.ListaControle

class CicloDeVidaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        println("ON CREATE")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_de_vida)

        findViewById<Button>(R.id.buttonNextPage).setOnClickListener {
            val intentSegundaTela = Intent(this, SegundaActivity::class.java)
            startActivity(intentSegundaTela)
        }
    }

    override fun onStart() {
        println("ON START")
        super.onStart()
    }

    override fun onResume() {
        println("ON RESUME")

        Snackbar.make(
            window.decorView,
            "Lista com: ${ListaControle.nomes.size} elementos",
            Snackbar.LENGTH_LONG
        ).show()

        super.onResume()
    }

    override fun onRestart() {
        println("ON RESTART")
        super.onRestart()
    }

    override fun onPause() {
        println("ON PAUSE")
        super.onPause()
    }

    override fun onStop() {
        println("ON STOP")
        super.onStop()
    }

    override fun onDestroy() {
        println("ON DESTROY")
        super.onDestroy()
    }


}