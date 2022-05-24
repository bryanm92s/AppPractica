package com.example.apppractica.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apppractica.R
import com.example.apppractica.db.UserDatabase
import com.example.apppractica.entity.User
import com.example.apppractica.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {


    /**
     * @param isExist  bool parameter Para chequear si el usuario existe o no en la base de datos.
     */
    var isExist = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //calling view mdioel object
        val userDetailsRepository = ViewModelProvider(this@SignUp).get(LoginViewModel::class.java)

        btnAceptar.setOnClickListener{

            if (validation()) {
                userDetailsRepository.getGetAllData().observe(this, object : Observer<List<User>> {
                    override fun onChanged(t: List<User>) {
                        var userObject = t

                        for (i in userObject.indices) {

                            if (userObject[i].name?.equals(textInputEditTextNombre.text.toString())!!) {
                                isExist = true
                                // Toast.makeText(this@SignUp," User Already Registered ", Toast.LENGTH_SHORT).show()
                                break

                            } else {
                                isExist = false
                                continue
                            }
                        }

                        if (isExist) {
                            Toast.makeText(this@SignUp, "Usuario ya se encuentra registrado!!! ", Toast.LENGTH_SHORT)
                                .show()

                        } else {

                            val user = User()
                            user.name = textInputEditTextNombre.text.toString()
                            user.email = textInputEditTextCorreo.text.toString()
                            user.password = textInputEditTextContrasena.text.toString()
                            val userDatabase = UserDatabase
                            userDatabase.getDatabase(this@SignUp)?.daoAccess()?.insertUserData(user)
                            Toast.makeText(this@SignUp, "Usuario registrado exitosamente", Toast.LENGTH_SHORT)
                                .show()

                            // Limpiar EditText
                            textInputEditTextNombre.setText("")
                            textInputEditTextCorreo.setText("")
                            textInputEditTextContrasena.setText("")

                            // Enviar al Login
                            val intent: Intent = Intent(this@SignUp, Login::class.java)
                            startActivity(intent)
                        }
                    }
                })
            }
        }

        btn_back_login.setOnClickListener {
            val intent: Intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    private fun validation(): Boolean {
        if (textInputEditTextNombre.text.isNullOrEmpty()) {
            Toast.makeText(this@SignUp, "Ingrese el usuario", Toast.LENGTH_SHORT).show()
            return false
        }
        if (textInputEditTextCorreo.text.isNullOrEmpty()) {
            Toast.makeText(this@SignUp, "Ingrese el correo electrónico", Toast.LENGTH_SHORT).show()
            return false
        }

        if (textInputEditTextContrasena.text.isNullOrEmpty()) {
            Toast.makeText(this@SignUp, "Ingrese la contraseña", Toast.LENGTH_SHORT).show()
            return false
        }

        if (textInputEditTextContrasena.text.toString().length <8) {
            Toast.makeText(this@SignUp, "La contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}

