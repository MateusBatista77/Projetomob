package com.example.projetomob.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projetomob.databinding.AcademiaItemBinding

class AcademiaAdapter(private val : context, private_val listaAcademia: MutableList<Academias>):
    RecyclerView.Adapter<AcademiaAdapter.AcademiasViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcademiasViewHolder {
        val itemLista = AcademiaItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return AcademiasViewHolder(itemLista)
    }

    override fun getItemCount() = listaAcademias.size

    override fun onBindViewHolder(holder: AcademiasViewHolder, position: Int) {
        holder.imgAcademia.setImageResource(listaAcademias[position].img!!)
        holder.txtServico.text = listaAcademias[position].nome
    }

    inner class AcademiasViewHolder(binding: AcademiaItemBinding): RecyclerView.ViewHolder(binding.root){
        val imgAcademia = binding.imgAcademia
        val txtAcademia = binding.txtAcademia
    }
}