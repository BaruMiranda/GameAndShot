package com.barcod.juegabebe.ui.container.twogame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.barcod.juegabebe.data.model.CardModel
import com.barcod.juegabebe.databinding.FragmentAlQueLeTocaTocaBinding
import com.barcod.juegabebe.ui.main.MainActivity


class AlQueLeTocaTocaFragment : Fragment() {

    private var _binding: FragmentAlQueLeTocaTocaBinding? = null
    private val binding get() = _binding!!

    fun newInstance(): AlQueLeTocaTocaFragment {
        return AlQueLeTocaTocaFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlQueLeTocaTocaBinding.inflate(inflater, container, false)
        confIU()
        return binding.root
    }

    private fun confIU() {

    }

}