package com.example.apppractica.register

import android.app.Application
import android.util.Log
import androidx.core.util.PatternsCompat
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import com.example.apppractica.database.RegisterEntity
import com.example.apppractica.database.RegisterRepository
import kotlinx.coroutines.*


class RegisterViewModel(private val repository: RegisterRepository, application: Application) :
    AndroidViewModel(application), Observable {

    init {
        Log.i("MYTAG", "init")
    }

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

    // Navigatoto
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
        Log.i("MYTAG", "Inside SUBMIT BUTTON")
        if (inputUsername.value == null || inputEmail.value == null || inputPassword.value == null) {
            _errorToast.value = true
        } else if (!PatternsCompat.EMAIL_ADDRESS.matcher(inputEmail.value.toString()).matches()) {
            _errorToastEmail.value = true
        } else if (inputPassword.value!!.length < 8) {
            _errorToastPassword.value = true
        } else {
            uiScope.launch {
                val usersNames = repository.getUserName(inputUsername.value!!)
                Log.i("MYTAG", usersNames.toString() + "------------------")
                if (usersNames != null) {
                    _errorToastUsername.value = true
                    Log.i("MYTAG", "Inside if Not null")
                } else {
                    Log.i("MYTAG", userDetailsLiveData.value.toString() + "ASDFASDFASDFASDF")
                    Log.i("MYTAG", "OK im in")
                    val name = inputUsername.value!!
                    val email = inputEmail.value!!
                    val password = inputPassword.value!!
                    Log.i("MYTAG", "insidi Sumbit")
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
        Log.i("MYTAG", "Done navigating ")
    }

    fun donetoast() {
        _errorToast.value = false
        Log.i("MYTAG", "Done taoasting ")
    }

    fun donetoastUserName() {
        _errorToast.value = false
        Log.i("MYTAG", "Done taoasting  username")
    }

    fun donetoastEmail() {
        _errorToast.value = false
        Log.i("MYTAG", "Done taoasting  Email")
    }

    fun donetoastPassword() {
        _errorToast.value = false
        Log.i("MYTAG", "Done taoasting  Password")
    }

    private fun insert(user: RegisterEntity): Job = viewModelScope.launch {
        repository.insert(user)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}





