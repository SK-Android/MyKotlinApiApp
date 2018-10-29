package adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.androidapp.mcs.mykotlinapiapp.R
import com.androidapp.mcs.mykotlinapiapp.pojo
import com.squareup.picasso.Picasso

class MyAdapter (private val context: Context,val pojoList: ArrayList<pojo>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onBindViewHolder(p0: ViewHolder, i: Int) {


        p0.txtTitle.text = pojoList[i].title
        p0.href.text = pojoList[i].href
        p0.ingredients.text = pojoList[i].ingredients
        p0.thumbnail.text = pojoList[i].thumbnail



    }



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)
        return ViewHolder(view)

    }



    override fun getItemCount(): Int {

        return pojoList.size

    }



    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val txtTitle = itemView.findViewById<TextView>(R.id.textView1)!!

        val href = itemView.findViewById<TextView>(R.id.textView3)!!
        val ingredients = itemView.findViewById<TextView>(R.id.textView2)!!
        val thumbnail = itemView.findViewById<TextView>(R.id.imageView)!!


    }



}
