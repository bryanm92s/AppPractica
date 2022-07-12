package com.example.apppractica.login

import android.app.Application
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apppractica.database.RegisterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: RegisterRepository, application: Application) :
    AndroidViewModel(application), Observable {

    val users = repository.users

    @Bindable
    val inputUsername = MutableLiveData<String?>()

    @Bindable
    val inputPassword = MutableLiveData<String?>()

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    // Navigate to Register
    private val _navigatetoRegister = MutableLiveData<Boolean>()

    val navigatetoRegister: LiveData<Boolean>
        get() = _navigatetoRegister

    // Navigate to Home
    private val _navigatetoHome = MutableLiveData<Boolean>()

    val navigatetoHome: LiveData<Boolean>
        get() = _navigatetoHome

    // Error toast
    private val _errorToast = MutableLiveData<Boolean>()

    val errortoast: LiveData<Boolean>
        get() = _errorToast

    // Error toast Username
    private val _errorToastUsername = MutableLiveData<Boolean>()

    val errortoastUsername: LiveData<Boolean>
        get() = _errorToastUsername

    // Error toast InvalidPassword
    private val _errorToastInvalidPassword = MutableLiveData<Boolean>()

    val errorToastInvalidPassword: LiveData<Boolean>
        get() = _errorToastInvalidPassword


    fun signUP() {
        _navigatetoRegister.value = true
    }

    fun loginButton() {
        if (inputUsername.value == null || inputPassword.value == null) {
            _errorToast.value = true
        } else {
            uiScope.launch {
                val usersNames = repository.getUserName(inputUsername.value!!)
                if (usersNames != null) {
                    if (usersNames.passwrd == inputPassword.value) {
                        inputUsername.value = null
                        inputPassword.value = null
                        _navigatetoHome.value = true
                    } else {
                        _errorToastInvalidPassword.value = true
                    }
                } else {
                    _errorToastUsername.value = true
                }
            }
        }
    }

    // Functions done

    fun doneNavigatingRegister() {
        _navigatetoRegister.value = false
    }

    fun doneNavigatingHome() {
        _navigatetoHome.value = false
    }

    fun donetoast() {
        _errorToast.value = false
    }

    fun donetoastErrorUsername() {
        _errorToastUsername.value = false
    }

    fun donetoastInvalidPassword() {
        _errorToastInvalidPassword.value = false
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}