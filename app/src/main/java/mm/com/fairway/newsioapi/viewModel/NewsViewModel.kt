package mm.com.fairway.newsioapi.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mm.com.fairway.newsioapi.api.ApiClient
import mm.com.fairway.newsioapi.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    private var result: MutableLiveData<News> = MutableLiveData()
    private var errorMessage: MutableLiveData<String> = MutableLiveData()
    fun getResult(): LiveData<News> = result
    fun loadResult() {
        var apiClient = ApiClient()
        var apiCall = apiClient.getTopHeadLines()
        apiCall.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
//                 txtResponse.text= t.toString()
                errorMessage.value = t.toString()
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
//               txtResponse.text= response.body()?.articles.toString()
                result.value = response.body()
            }

        })
    }
}