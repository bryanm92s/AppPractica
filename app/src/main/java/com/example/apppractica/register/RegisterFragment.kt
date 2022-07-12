package com.example.apppractica.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.apppractica.database.RegisterDatabase
import com.example.apppractica.database.RegisterRepository
import com.example.apppractica.databinding.RegisterHomeFragmentBinding


class RegisterFragment : Fragment() {

    private var _binding: RegisterHomeFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterHomeFragmentBinding.inflate(inflater, container,false)

        val application = requireNotNull(this.activity).application

        val dao = RegisterDatabase.getInstance(application).registerDatabaseDao

        val repository = RegisterRepository(dao)

        val factory = RegisterViewModelFactory(repository, application)

        registerViewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)

        binding.myViewModel = registerViewModel

        binding.lifecycleOwner = this

        // Navigate to Login
        registerViewModel.navigateto.observe(viewLifecycleOwner, Observer { hasFinished ->
            if (hasFinished == true) {
                displayLogin()
                registerViewModel.doneNavigating()
            }
        })


        // Error toast
        registerViewModel.errortoast.observe(viewLifecycleOwner, Observer { hasError ->
            if (hasError == true) {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT)
                    .show()
                registerViewModel.donetoast()
            }
        })
        
        // Error Username
        registerViewModel.errortoastUsername.observe(viewLifecycleOwner, Observer { hasError ->
            if (hasError == true) {
                Toast.makeText(requireContext(), "UserName Already taken", Toast.LENGTH_SHORT)
                    .show()
                registerViewModel.donetoastUserName()
            }
        })

        // Error Email
        registerViewModel.errortoastEmail.observe(viewLifecycleOwner, Observer { hasError ->
            if (hasError == true) {
                Toast.makeText(requireContext(), "Enter a valid email", Toast.LENGTH_SHORT).show()
                registerViewModel.donetoastEmail()
            }
        })

        // Error Password
        registerViewModel.errortoastPassword.observe(viewLifecycleOwner, Observer { hasError ->
            if (hasError == true) {
                Toast.makeText(
                    requireContext(),
                    "Password must contain at least 8 characters",
                    Toast.LENGTH_SHORT
                ).show()
                registerViewModel.donetoastPassword()
            }
        })

        //Go to login
        binding.btnBackLogin.setOnClickListener {
            val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
            NavHostFragment.findNavController(this).navigate(action)

        }

        return binding.root

    }


    private fun displayLogin(){
        Toast.makeText(requireContext(), "User created successfully", Toast.LENGTH_SHORT).show()
        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
}