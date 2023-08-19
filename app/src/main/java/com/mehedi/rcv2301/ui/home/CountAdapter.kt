package com.mehedi.rcv2301.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mehedi.rcv2301.databinding.ItemCountBinding
import com.mehedi.rcv2301.models.Love

class CountAdapter(
    var loveListener: LoveListener,
    var context: Context,
    var loveList: MutableList<Love>
) :
    RecyclerView.Adapter<CountViewHolder>() {


    interface LoveListener {

        fun loveItemClick(love: Love)

        fun deleteLoveItem(love: Love)
        fun updateLoveItem(love: Love)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountViewHolder {

        val binding = ItemCountBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )


        return CountViewHolder(binding)

    }


    override fun onBindViewHolder(holder: CountViewHolder, position: Int) {

        loveList[position].let {


            holder.binding.run {

                nameTextView.text = it.name
                // detailsTextView.text = it.details
                imageView.load(it.img)
                num.text = "ID : ${it._id}"

                deleteBtn.setOnClickListener { _ ->
                    loveListener.deleteLoveItem(it)


                }

                updateBtn.setOnClickListener { _ ->

                    loveListener.updateLoveItem(it)


                }


            }




            holder.itemView.setOnClickListener { _ ->


                Toast.makeText(context, "${it.name}", Toast.LENGTH_SHORT).show()

                loveListener.loveItemClick(it)

            }


        }


    }

    override fun getItemCount(): Int {

        return loveList.size

    }


}