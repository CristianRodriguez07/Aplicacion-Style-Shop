package com.example.aplicacionstyleshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val Nombre: EditText = findViewById(R.id.editTextNombre)
        val mail: EditText = findViewById(R.id.editTextEmail)
        val contra: EditText = findViewById(R.id.editTextContraseña)
        val confirmarcontra: EditText = findViewById(R.id.editTextConfirm)
        val apellido: EditText = findViewById(R.id.editTextApellido)
        val botonregistrar: Button = findViewById(R.id.buttonRegistrarse)

        botonregistrar.setOnClickListener {
            if (Nombre.text.isNotEmpty() && mail.text.isNotEmpty() && contra.text.isNotEmpty() && confirmarcontra.text.isNotEmpty()) {
                if (contra.text.toString().equals(confirmarcontra.text.toString())) {
                    Toast.makeText(this, "Registro completado", Toast.LENGTH_LONG).show()
                    val intentRegistrarse = Intent(this, PaginaPrincipal::class.java)
                    var Nombre: String = Nombre.text.toString()
                    intentRegistrarse.putExtra("Nombre", Nombre)
                    intentRegistrarse.setClassName(this, "com.example.aplicacionstyleshop.PaginaPrincipal")
                    startActivity(intentRegistrarse)
                } else {
                    Toast.makeText(this, "No coincide", Toast.LENGTH_LONG).show()
                }
            } else {
                if (Nombre.text.isEmpty()) {
                    Toast.makeText(this, "Rellena el nombre", Toast.LENGTH_LONG).show()
                } else if (mail.text.isEmpty()) {
                    Toast.makeText(this, "Rellena el email", Toast.LENGTH_LONG).show()
                } else if (contra.text.isEmpty()) {
                    Toast.makeText(this, "Rellena el contraseña", Toast.LENGTH_LONG).show()
                } else if (confirmarcontra.text.isEmpty()) {
                    Toast.makeText(this, "Rellena el contraseña", Toast.LENGTH_LONG).show()
                }else if (apellido.text.isEmpty()) {
                    Toast.makeText(this, "Rellena la fecha", Toast.LENGTH_LONG).show()
                }
            }
        }
        class Persona(var nombre: String, var apellido: String, var email: String, var contraseña: String) {
            override fun toString(): String {
                return "Persona(nombre='$nombre', apellido='$apellido', email='$email', contraseña='$contraseña')"
            }
        }

    }
}