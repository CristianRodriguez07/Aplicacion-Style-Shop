package com.example.aplicacionstyleshop

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PaginaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_principal)

        val salir: Button = findViewById(R.id.buttonSalir)
        val Saludo: TextView = findViewById(R.id.txtSaludo)
        val Llamar: Button = findViewById(R.id.buttonLlamar)
        val maps: Button = findViewById(R.id.buttonubicacion)

        val ObjetoIntent: Intent = intent
        var Nombre = ObjetoIntent.getStringExtra("Nombre")
        Saludo.text = "Hola Bienvenido a Style Shop $Nombre "

        salir.setOnClickListener {
            val intentSalir = Intent(this, MainActivity::class.java)
            val intentSalirAlternativa = Intent()
            intentSalirAlternativa.setClassName(
                this,
                "com.example.aplicacionstyleshop.MainActivity"
            )
            startActivity(intentSalirAlternativa)
        }
        Llamar.setOnClickListener {
            val intentLlamada = Intent()
            intentLlamada.setAction(Intent.ACTION_DIAL)
            intentLlamada.data = Uri.parse("tel:914685293")
            startActivity(intentLlamada)
        }
        maps.setOnClickListener {
            val intentMaps = Intent()
            intentMaps.setAction(Intent.ACTION_VIEW)
            intentMaps.data = Uri.parse("geo:0,0?q=Style+Shop")
            startActivity(intentMaps)
        }

}
}