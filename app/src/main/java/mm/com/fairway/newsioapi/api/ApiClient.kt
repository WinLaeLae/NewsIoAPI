package mm.com.fairway.newsioapi.api

import com.google.gson.Gson
import mm.com.fairway.newsioapi.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private  val BASE_URL="https://newsapi.org/v2/"
   // private var retrofit: Retrofit?=null
    val apiInterface:NewaAPIInterface
    init {
       var retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface= retrofit.create(NewaAPIInterface::class.java)
    }

    fun  getTopHeadLines(): Call<News>{
        return apiInterface.getTopHeadlines(// call fun to give country name and
            "us",
            "b90dd3c699c94e97944d7cc600740c26"
        )
    }
}