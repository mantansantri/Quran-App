package com.idn.alquranapp.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.alquranapp.databinding.ItemSurahBinding
import com.idn.alquranapp.network.quran.SurahItem


class ListSurahAdapter :RecyclerView.Adapter<ListSurahAdapter.SurahViewHolder>() {
    val listSurah = ArrayList<SurahItem>()

    fun setData(list: List<SurahItem>?) {
        if (list == null) return
        listSurah.clear()
        listSurah.addAll(list)
    }
    class SurahViewHolder(val binding: ItemSurahBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SurahViewHolder(
        ItemSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = listSurah.size

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        val data = listSurah[position]
        holder.binding.apply {
            tvSurah.text = data.englishName
            val revelationType = data.revelationType
            val numberOfAyahs = data.numberOfAyahs
            val resultOfAyah = "$revelationType - $numberOfAyahs Ayahs"
            tvAyah.text = resultOfAyah
            tvName.text = data.name
            tvNumber.text = data.number.toString()
        }
    }
}