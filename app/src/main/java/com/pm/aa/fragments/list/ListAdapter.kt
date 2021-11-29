package com.pm.aa.fragments.list

import android.graphics.Color
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pm.aa.R
import com.pm.aa.data.entities.Product
import com.pm.aa.data.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var productList = emptyList<Product>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.itemView.IdProduto.text = currentItem.id.toString()
        holder.itemView.Produto.text = currentItem.name
        holder.itemView.Marca.text = currentItem.marca
        holder.itemView.Teor.text = currentItem.teor


        if(position%2 == 0){
            holder.itemView.rowLayout.setBackgroundColor(Color.parseColor("#FFA500"))
        }
        else {
            holder.itemView.rowLayout.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun setData(Product: List<Product>)
    {
        this.productList = Product
        notifyDataSetChanged()
    }

}