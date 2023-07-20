package org.demre.recyclerpaiseskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.demre.recyclerpaiseskotlin.databinding.ItemLayoutBinding

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {

    var paises = mutableListOf<Pais>()
    var callback: PaisCallback ? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return paises.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = paises[position]
        holder.bind(item)

    }

    fun setData(paises: MutableList<Pais>) {
        this.paises = paises.toMutableList()

    }


    inner class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pais) {
            binding.tVnombrePais.text = item.nombre
            binding.iVpaises.load(item.imgUrl)
            binding.cVpaises.setOnClickListener(View.OnClickListener {

                val texto = "El país de ${item.nombre} tiene una población de:${item.poblacion}"
                callback?.showCountry(texto)
            })
        }
    }
    interface PaisCallback{
        fun showCountry(texto: String)
    }
}