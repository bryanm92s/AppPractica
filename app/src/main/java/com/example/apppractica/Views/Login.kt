package com.example.apppractica.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apppractica.R
import com.example.apppractica.databinding.ActivityLoginBinding
import com.example.apppractica.entity.User
import com.example.apppractica.viewmodel.LoginViewModel


class Login : AppCompatActivity() {

    /**
     * @param isExist  bool parameter Para chequear si el usuario existe o no en la base de datos.
     */
    var isExist = false
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Llamando el view model
        val userDetailsRepository = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.btnLogin.setOnClickListener {

            if (validation()) {

                userDetailsRepository.getGetAllData().observe(this, object : Observer<List<User>> {
                    override fun onChanged(t: List<User>) {
                        var userObject = t

                        for (i in userObject.indices) {

                            if (userObject[i].name?.equals(binding.etUser.text.toString())!!) {

                                if (userObject[i].password?.equals(binding.etPassword.text.toString())!!) {

                                    val intent = Intent(this@Login, MainActivity::class.java)
                                        .putExtra("UserDetails", userObject[i])
                                    // start your next activity
                                    startActivity(intent)

                                } else {
                                    Toast.makeText(this@Login, "La contraseña es incorrecta", Toast.LENGTH_SHORT).show()
                                }
                                isExist = true
                                break
                            } else {
                                isExist = false
                            }
                        }
                        if (isExist) {
                           // Toast.makeText(this@Login, "Bienvenido", Toast.LENGTH_SHORT)
                            //    .show()
                        } else {
                            Toast.makeText(this@Login, "Usuario no registrado", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                })
            }
        }

        binding.btnRegistrate.setOnClickListener {
            val intent: Intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }

    private fun validation(): Boolean {

        if (binding.etUser.text.isNullOrEmpty()) {
            Toast.makeText(this@Login, "Ingrese el usuario", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.etPassword.text.isNullOrEmpty()) {
            Toast.makeText(this@Login, "Ingrese la contraseña", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.etPassword.text.toString().length < 8) {
            Toast.makeText(
                this@Login,
                "La contraseña debe tener al menos 8 caracteres",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }
        return true
    }
}