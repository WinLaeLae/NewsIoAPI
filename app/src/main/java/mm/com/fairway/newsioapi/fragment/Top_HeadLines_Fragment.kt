package mm.com.fairway.newsioapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_top__head_lines_.*
import mm.com.fairway.newsioapi.R
import mm.com.fairway.newsioapi.adapter.TopHeadLinesAdapter
import mm.com.fairway.newsioapi.api.ApiClient
import mm.com.fairway.newsioapi.model.Article
import mm.com.fairway.newsioapi.model.News
import mm.com.fairway.newsioapi.viewModel.NewsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Top_HeadLines_Fragment : Fragment() {
    var newsViewModel=NewsViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top__head_lines_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        newsViewModel.loadResult()
        newsViewModel.getResult().observe(viewLifecycleOwner, Observer {
            recyclerView_HeadLines.apply {
                layoutManager=LinearLayoutManager(context)
                adapter=TopHeadLinesAdapter(it.articles as ArrayList<Article>)

            }
        })

//        var  apiClient=ApiClient()
//        var apiCall=apiClient.getTopHeadLines()
//        apiCall.enqueue(object: Callback<News>{
//            override fun onFailure(call: Call<News>, t: Throwable) {
////                 txtResponse.text= t.toString()
//
//            }
//
//            override fun onResponse(call: Call<News>, response: Response<News>) {
////               txtResponse.text= response.body()?.articles.toString()
//            }
//
//        })
    }
}