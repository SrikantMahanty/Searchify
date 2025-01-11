package com.srikant.searchify
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srikant.searchify.model.WebSearch
import com.srikant.searchify.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel(private val repository: Repository) : ViewModel() {
    val myResponse: MutableLiveData<Response<WebSearch>> = MutableLiveData()

    fun getWebSearch(query: String, pNumber: Int, pSize: Int, autoCorrect: String,h1:String) {
        viewModelScope.launch {
            val response: Response<WebSearch> =
                repository.getWebSearch(query, pNumber, pSize, autoCorrect,h1)
            myResponse.value = response
        }
    }
}