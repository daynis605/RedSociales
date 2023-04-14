package com.app.gantabi.auth.domain


import com.app.gantabi.auth.data.AccountRepository
import javax.inject.Inject


class LoginUserCU @Inject constructor(private val repository: AccountRepository) {

  /*  suspend operator fun invoke(): List<Quote>? {
        val quotes = repository.getAllQuotesFromApi()
        return if (!quotes.isNullOrEmpty()){
            repository.clearQuotes()
            repository.insertQuoteInDatabase(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.gatAllQuoteFromDatabase()
        }

    }
*/
}