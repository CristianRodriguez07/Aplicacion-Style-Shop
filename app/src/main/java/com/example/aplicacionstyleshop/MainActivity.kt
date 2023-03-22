package com.example.aplicacionstyleshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Nombre: EditText = findViewById(R.id.editTextNombre)
        val Contra: EditText = findViewById(R.id.editTextContraseña)
        val botonIngresar: Button = findViewById(R.id.buttonIngresar)
        val botonRegistrar: Button = findViewById(R.id.buttonRegistrar)

        botonRegistrar.setOnClickListener {
            val intentRegistro = Intent(this,Registro::class.java)
            val intentRegistroAlternativa = Intent()
            intentRegistroAlternativa.setClassName(this, "com.example.aplicacionstyleshop.Registro")
            startActivity(intentRegistroAlternativa)
        }

        botonIngresar.setOnClickListener {
            if (Nombre.text.isNotEmpty() && Contra.text.isNotEmpty()) {
                val intentIngresar: Intent = Intent(this, PaginaPrincipal::class.java)
                val intentIngresarAlternativa = Intent()
                intentIngresarAlternativa.setClassName(this, "com.example.aplicacionstyleshop.PaginaPrincipal")
                var Nombre: String = Nombre.text.toString()
                intentIngresarAlternativa.putExtra("Nombre", Nombre)
                startActivity(intentIngresarAlternativa)
            } else {
                if (Nombre.text.isEmpty()) {
                    Toast.makeText(this, "Rellena el nombre", Toast.LENGTH_LONG).show()
                } else if (Contra.text.isEmpty()) {
                    Toast.makeText(this, "Rellena el contraseña", Toast.LENGTH_LONG).show()
                }


            }


        }

    }
}