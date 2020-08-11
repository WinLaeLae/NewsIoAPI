package mm.com.fairway.newsioapi.api

import mm.com.fairway.newsioapi.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewaAPIInterface {
    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country:String,//to give parameter and use @Query()
        @Query("apiKey") apiKey:String

    ):Call<News>
}