package com.example.apppractica.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apppractica.R
import com.example.apppractica.databinding.ActivitySignUpBinding
import com.example.apppractica.db.UserDatabase
import com.example.apppractica.entity.User
import com.example.apppractica.viewmodel.LoginViewModel


class SignUp : AppCompatActivity() {


    /**
     * @param isExist  bool parameter Para chequear si el usuario existe o no en la base de datos.
     */
    var isExist = false
    private lateinit var binding: ActivitySignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //calling view model object
        val userDetailsRepository = ViewModelProvider(this@SignUp).get(LoginViewModel::class.java)


        binding.btnBackLogin.setOnClickListener {
            val intent: Intent = Intent(this@SignUp, Login::class.java)
            startActivity(intent)
        }

        binding.btnAceptar.setOnClickListener {

            if (validation()) {
                userDetailsRepository.getGetAllData().observe(this, object : Observer<List<User>> {
                    override fun onChanged(t: List<User>) {
                        var userObject = t

                        for (i in userObject.indices) {

                            if (userObject[i].name?.equals(binding.textInputEditTextNombre.text.toString())!!) {
                                isExist = true
                                //Toast.makeText(this@SignUp,"Usuario ya se encuentra registrado", Toast.LENGTH_SHORT).show()
                                break

                            } else {
                                isExist = false

                                continue
                            }
                        }

                        if (isExist) {
                             Toast.makeText(this@SignUp,"Usuario ya se encuentra registrado", Toast.LENGTH_SHORT).show()
                        }
                        else {

                            val user = User()
                            user.name = binding.textInputEditTextNombre.text.toString()
                            user.email = binding.textInputEditTextCorreo.text.toString()
                            user.password = binding.textInputEditTextContrasena.text.toString()
                            val userDatabase = UserDatabase
                            userDatabase.getDatabase(this@SignUp)?.daoAccess()?.insertUserData(user)
                            Toast.makeText(
                                this@SignUp,
                                "Usuario registrado exitosamente",
                                Toast.LENGTH_SHORT
                            )
                                .show()

                            // Limpiar EditText
                            binding.textInputEditTextNombre.setText("")
                            binding.textInputEditTextCorreo.setText("")
                            binding.textInputEditTextContrasena.setText("")

                            // Enviar al Login
                            val intent: Intent = Intent(this@SignUp, Login::class.java)
                            startActivity(intent)

                            //isExist = true
                        }
                    }
                })
            }
        }
    }
    private fun validation(): Boolean {
        if (binding.textInputEditTextNombre.text.isNullOrEmpty()) {
            Toast.makeText(this@SignUp, "Ingrese el usuario", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.textInputEditTextCorreo.text.isNullOrEmpty()) {
            Toast.makeText(this@SignUp, "Ingrese el correo electrónico", Toast.LENGTH_SHORT).show()
            return false
        }else if (!PatternsCompat.EMAIL_ADDRESS.matcher(binding.textInputEditTextCorreo.text.toString()).matches()){
            Toast.makeText(this@SignUp,"Por favor ingrese un correo electrónico válido",Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.textInputEditTextContrasena.text.isNullOrEmpty()) {
            Toast.makeText(this@SignUp, "Ingrese la contraseña", Toast.LENGTH_SHORT).show()
            return false
        }

        if (binding.textInputEditTextContrasena.text.toString().length <8) {
            Toast.makeText(this@SignUp, "La contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}

