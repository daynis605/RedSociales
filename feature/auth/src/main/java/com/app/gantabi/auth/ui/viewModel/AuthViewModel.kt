package com.app.gantabi.auth.ui.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.gantabi.auth.data.AccountRepository
import com.app.gantabi.auth.data.model.toDto
import com.app.gantabi.auth.domain.model.Account
import com.app.gantabi.auth.domain.model.Session
import com.app.gantabi.auth.ui.view.LoginResultCallBacks
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val respository: AccountRepository,
    private val example: @JvmSuppressWildcards LoginResultCallBacks
) : ViewModel() {

    private val _uiAccount = MutableLiveData<Account>()
    val _uiToken = MutableLiveData<Session>()


    fun login(email: String, password: String) {
        _uiToken.value = Session()
        val account = Account(
            email,
            password
        )
        viewModelScope.launch {
            try {
                println("Peticion Haciendose:")
                println(account)
                var result: Session? = respository.loginUserFromApi(account.toDto())

                if (result != null) {
                    result.code = 200
                    _uiToken.value = result!!
                    example.onSuccess("200")
                } else {
                    _uiToken.value = Session(code = 400)

                    //  example.onError("400")
                }

                println("RESULTADO $result")
            } catch (ex: Exception) {
                println("GERARD")
            }


        }
    }

}


/*

    val quoteModel = MutableLiveData<Quote>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result: List<Quote>? = getQuoteUseCase()
            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote: Quote? = getRamdomQuoteUseCase()
            if (quote != null) {
                quoteModel.postValue(quote!!)
            }
            isLoading.postValue(false)
        }


    }



 */