package com.barcod.juegabebe.ui.container.fourgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.barcod.juegabebe.databinding.FragmentToditoBinding
import com.barcod.juegabebe.data.model.CardModel
import com.barcod.juegabebe.ui.main.MainActivity


class ToditoFragment : Fragment() {

    private var _binding: FragmentToditoBinding? = null
    private val binding get() = _binding!!

    private lateinit var cardAdapter: CardAdapter


    fun newInstance(): ToditoFragment {
        return ToditoFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToditoBinding.inflate(inflater, container, false)
        confIU()
        return binding.root
    }

    private fun confIU() {
        (activity as MainActivity?)!!.mToolbar(value = false)

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        val cardList = mutableListOf(
            CardModel("T"),
            CardModel("O"),
            CardModel("D"),
            CardModel("I"),
            CardModel("T"),
            CardModel("O")
        )

        cardAdapter = CardAdapter(cardList)
        binding.recyclerView.adapter = cardAdapter
    }

}