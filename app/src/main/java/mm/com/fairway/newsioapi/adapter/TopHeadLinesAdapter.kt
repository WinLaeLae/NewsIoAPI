package mm.com.fairway.newsioapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_top_head_lines_layout.view.*
import mm.com.fairway.newsioapi.R
import mm.com.fairway.newsioapi.model.Article

class TopHeadLinesAdapter (var newsList:ArrayList<Article>):RecyclerView.Adapter<TopHeadLinesAdapter.TopHeadViewHolder>(){
    class TopHeadViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(article: Article){
            itemView.channel_nametxt.text=article.source.name
            itemView.authortxt.text=article.author
            itemView.descriptiontxt.text=article.description
            Picasso.get().load(article.urlToImage).into(itemView.queen_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadViewHolder {
       return TopHeadViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_top_head_lines_layout,parent,false))
    }

    override fun getItemCount(): Int {
       return newsList.size
    }

    override fun onBindViewHolder(holder: TopHeadViewHolder, position: Int) {
       holder.bind(newsList[position])
    }
}