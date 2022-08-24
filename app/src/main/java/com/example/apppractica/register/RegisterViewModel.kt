package com.example.apppractica.register

import android.app.Application
import androidx.core.util.PatternsCompat
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.apppractica.database.RegisterEntity
import com.example.apppractica.database.RegisterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class RegisterViewModel(private val repository: RegisterRepository, application: Application) :
    AndroidViewModel(application), Observable {

    private var userdata: String? = null

    var userDetailsLiveData = MutableLiveData<Array<RegisterEntity>>()

    @Bindable
    val inputUsername = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val inputPassword = MutableLiveData<String>()

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    // Navigate to
    private val _navigateto = MutableLiveData<Boolean>()

    val navigateto: LiveData<Boolean>
        get() = _navigateto

    // Error toast
    private val _errorToast = MutableLiveData<Boolean>()

    val errortoast: LiveData<Boolean>
        get() = _errorToast

    // Error toast UserName
    private val _errorToastUsername = MutableLiveData<Boolean>()

    val errortoastUsername: LiveData<Boolean>
        get() = _errorToastUsername

    // Error toast Email
    private val _errorToastEmail = MutableLiveData<Boolean>()

    val errortoastEmail: LiveData<Boolean>
        get() = _errorToastEmail

    // Error toast Password
    private val _errorToastPassword = MutableLiveData<Boolean>()

    val errortoastPassword: LiveData<Boolean>
        get() = _errorToastPassword


    fun sumbitButton() {
        if (inputUsername.value == null || inputEmail.value == null || inputPassword.value == null) {
            _errorToast.value = true
        } else if (!PatternsCompat.EMAIL_ADDRESS.matcher(inputEmail.value.toString()).matches()) {
            _errorToastEmail.value = true
        } else if (inputPassword.value!!.length < 8) {
            _errorToastPassword.value = true
        } else {
            uiScope.launch {
                val usersNames = repository.getUserName(inputUsername.value!!)
                if (usersNames != null) {
                    _errorToastUsername.value = true
                } else {
                    val name = inputUsername.value!!
                    val email = inputEmail.value!!
                    val password = inputPassword.value!!
                    insert(RegisterEntity(0, name, email, password))
                    inputUsername.value = null
                    inputEmail.value = null
                    inputPassword.value = null
                    _navigateto.value = true
                }
            }
        }
    }

    // Functions done
    fun doneNavigating() {
        _navigateto.value = false
    }

    fun donetoast() {
        _errorToast.value = false
    }

    fun donetoastUserName() {
        _errorToast.value = false
    }

    fun donetoastEmail() {
        _errorToast.value = false
    }

    fun donetoastPassword() {
        _errorToast.value = false
    }

    private fun insert(user: RegisterEntity): Job = viewModelScope.launch {
        repository.insert(user)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}





