package com.barcod.juegabebe.ui.container.onegame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barcod.juegabebe.databinding.FragmentYoNuncaNuncaBinding
import com.barcod.juegabebe.ui.main.MainActivity


class YoNuncaNuncaFragment : Fragment() {

    private var _binding: FragmentYoNuncaNuncaBinding? = null
    private val binding get() = _binding!!

    fun newInstance(): YoNuncaNuncaFragment {
        return YoNuncaNuncaFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentYoNuncaNuncaBinding.inflate(inflater, container, false)
        confIU()
        return binding.root
    }

    private fun confIU() {
        (activity as MainActivity?)!!.mToolbar(value = false)
    }

}