package com.proway.listainterfaceevents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proway.listainterfaceevents.singleton.ListaControle

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        ListaControle.nomes.remove("Arthur")



    }
}