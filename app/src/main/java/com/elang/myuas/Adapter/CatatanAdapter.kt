package com.elang.myuas.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.elang.myuas.Model.CatatanModel
import com.elang.myuas.R

class CatatanAdapter (
    val catatans: ArrayList<CatatanModel.Data>
): RecyclerView.Adapter<CatatanAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.absenlist, parent, false)
    )

    override fun onBindViewHolder(holder: CatatanAdapter.ViewHolder, position: Int) {
        val data = catatans[position]
        holder.textCatatan.text = data.nim
        holder.textNim.text = data.nama
    }

    override fun getItemCount() = catatans.size

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textNim = view.findViewById<TextView>(R.id.text_catatan)
        val textCatatan = view.findViewById<TextView>(R.id.text_waktu)

//        val textWaktu = view.findViewById<TextView>(R.id.text_waktu)
    }

    public fun setData(data: List<CatatanModel.Data>){
        catatans.clear()
        catatans.addAll(data)
        notifyDataSetChanged()
    }

}