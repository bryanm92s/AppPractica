package com.example.apppractica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apppractica.modelorentity.User
import com.example.apppractica.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class Login : AppCompatActivity() {

    /**
     * @param isExist  bool parameter Para chequear si el usuario existe o no en la base de datos.
     */
    var isExist = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Llamando el view model
        val userDetailsRepository = ViewModelProvider(this).get(LoginViewModel::class.java)

        btnLogin.setOnClickListener {

            if (validation()) {

                userDetailsRepository.getGetAllData().observe(this, object : Observer<List<User>> {
                    override fun onChanged(t: List<User>) {
                        var userObject = t

                        for (i in userObject.indices) {

                            if (userObject[i].name?.equals(etUser.text.toString())!!) {

                                if (userObject[i].password?.equals(etPassword.text.toString())!!) {

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

        btnRegistrate.setOnClickListener {
            val intent: Intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }

    private fun validation(): Boolean {

        if (etUser.text.isNullOrEmpty()) {
            Toast.makeText(this@Login, "Ingrese el usuario", Toast.LENGTH_SHORT).show()
            return false
        }

        if (etPassword.text.isNullOrEmpty()) {
            Toast.makeText(this@Login, "Ingrese la contraseña", Toast.LENGTH_SHORT).show()
            return false
        }

        if (etPassword.text.toString().length < 8) {
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