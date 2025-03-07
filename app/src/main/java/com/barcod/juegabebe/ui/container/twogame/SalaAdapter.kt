package com.barcod.juegabebe.ui.container.twogame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.barcod.juegabebe.R
import com.barcod.juegabebe.data.model.CardModel

class SalaAdapter(
    private val cards: MutableList<CardModel>,
    private val onAddSalaClicked: () -> Unit,
    private val onSalaClicked: (CardModel) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ADD_SALA = 0
    private val TYPE_SALA = 1

    // ViewHolder para el card estático "Agregar Sala"
    class AddSalaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val container: LinearLayout = itemView.findViewById(R.id.addSalaContainer)
    }

    // ViewHolder para las salas
    class SalaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCardFront: LinearLayout = itemView.findViewById(R.id.ivCardFront)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val ivCardBack: ImageView = itemView.findViewById(R.id.ivCardBack)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_ADD_SALA else TYPE_SALA
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_ADD_SALA) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_add_sala, parent, false)
            AddSalaViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_add_sala, parent, false)
            SalaViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AddSalaViewHolder) {
            holder.container.setOnClickListener { onAddSalaClicked() }
        } else if (holder is SalaViewHolder) {
            val card = cards[position - 1] // Restar 1 porque el primer elemento es el card estático

            if (card.isRevealed) {
                holder.ivCardBack.visibility = View.GONE
                holder.ivCardFront.visibility = View.VISIBLE
                holder.tvDescription.text = getCardDrawable(card.letter)
            } else {
                holder.ivCardBack.visibility = View.VISIBLE
                holder.ivCardFront.visibility = View.GONE
            }

            holder.itemView.setOnClickListener { onSalaClicked(card) }
        }
    }

    override fun getItemCount(): Int = cards.size + 1 // +1 por el card estático

    private fun getCardDrawable(letter: String): String {
        return when (letter) {
            "T" -> "Toma \nTodo"
            "O" -> "Ordena\nQuien\nToma"
            "D" -> "Toma\nTu\nDerecha"
            "I" -> "Toma\nTu\nIzquierda"
            else -> "Toma\nNomas"
        }
    }
}
