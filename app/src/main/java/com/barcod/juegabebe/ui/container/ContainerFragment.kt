package com.barcod.juegabebe.ui.container

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import android.view.ViewGroup
import com.barcod.juegabebe.data.model.response.CategoryResponse
import com.barcod.juegabebe.databinding.FragmentContainerBinding
import com.barcod.juegabebe.ui.main.MainActivity
import com.barcod.juegabebe.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContainerFragment : Fragment() {

    private var _binding: FragmentContainerBinding? = null
    private val binding get() = _binding!!

    private val categoryViewModel: CategoryViewModel by viewModels()

    private lateinit var  listCategory : List<CategoryResponse>

    fun newInstance(): ContainerFragment {
        return ContainerFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContainerBinding.inflate(inflater, container, false)
        confIU()
        observer()
        return binding.root
    }

    private fun observer() {

        categoryViewModel.itemCategoryLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                listCategory = it
                binding.tvTodito.text = it[2].descripcion
                binding.tvTocaToca.text = it[3].descripcion
                binding.tvSiHaTodo.text = it[1].descripcion
                binding.tvYoNuncaNunca.text = it[0].descripcion
            }
        }

    }

    private fun confIU() {
        (activity as MainActivity?)!!.mToolbar(value = true)
        categoryViewModel.getCategory()

        binding.cardTodito.setOnClickListener {
            IDCATEGORY = listCategory[2].id.toString()
            DESCRIPTIONCATEGORY = listCategory[2].descripcion
            (activity as MainActivity?)!!.verToditoFragment()
        }

        binding.cardTocaToca.setOnClickListener {
            IDCATEGORY = listCategory[3].id.toString()
            DESCRIPTIONCATEGORY = listCategory[3].descripcion
            (activity as MainActivity?)!!.verAlQueLeTocaTocaFragment()
        }

        binding.cardSiHaTodo.setOnClickListener {
            IDCATEGORY = listCategory[1].id.toString()
            DESCRIPTIONCATEGORY = listCategory[1].descripcion
            (activity as MainActivity?)!!.verSiHaTodoFragment()
        }

        binding.cardYoNuncaNunca.setOnClickListener {
            IDCATEGORY = listCategory[0].id.toString()
            DESCRIPTIONCATEGORY = listCategory[0].descripcion
            (activity as MainActivity?)!!.verYoNuncaNuncaFragment()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as MainActivity?)!!.mToolbar(value = false)
    }

}