package com.selwan.schools365teacher.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.selwan.schools365teacher.data.model.login.AccessLogin
import io.reactivex.disposables.CompositeDisposable

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    var compositeDisposable: CompositeDisposable
    var loginRepository :  LoginRepository

    init {
        compositeDisposable = CompositeDisposable()
        loginRepository = LoginRepository(application)
    }

    fun getLoginMsg(email : String, password: String): LiveData<AccessLogin>{
        loginRepository.login(compositeDisposable, email, password)
        return loginRepository.msg
    }

}
