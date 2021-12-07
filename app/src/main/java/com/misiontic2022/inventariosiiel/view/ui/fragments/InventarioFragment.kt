package com.misiontic2022.inventariosiiel.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.misiontic2022.inventariosiiel.R
import com.misiontic2022.inventariosiiel.databinding.FragmentInventarioBinding
import com.misiontic2022.inventariosiiel.model.productd
import com.misiontic2022.inventariosiiel.view.adapter.ProductAdapter
import com.misiontic2022.inventariosiiel.view.adapter.ProductListener
import com.misiontic2022.inventariosiiel.viewmodel.OrderViewModel

class InventarioFragment : Fragment(),ProductListener {

    private var _binding: FragmentInventarioBinding? = null
    private val binding get() = _binding!!

    private lateinit var productsAdapter: ProductAdapter
    private lateinit var orderViewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInventarioBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
        }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        orderViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        orderViewModel.refresh()

        productsAdapter = ProductAdapter(this)

        binding.rvInventario.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = productsAdapter
        }

        observeViewModel()
    }

    fun observeViewModel() {
        orderViewModel.listProducts.observe(viewLifecycleOwner, Observer<List<productd>> { products ->
            productsAdapter.updateData(products)
        })

        orderViewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean>{
            if (it != null)
                binding.rlBaseInventario.visibility = View.INVISIBLE
        })
    }

    override fun onProductsClick(product: productd, position: Int) {
        val bundle = bundleOf("product" to product)
        findNavController().navigate(R.id.inventarioDetailFragmentDialog,bundle)
    }

}