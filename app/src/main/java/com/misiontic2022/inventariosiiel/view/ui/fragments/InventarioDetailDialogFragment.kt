package com.misiontic2022.inventariosiiel.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.misiontic2022.inventariosiiel.databinding.FragmentInventarioDetailDialogBinding
import com.misiontic2022.inventariosiiel.model.productd
import com.squareup.picasso.Picasso

class InventarioDetailDialogFragment : DialogFragment() {

    private var _binding: FragmentInventarioDetailDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInventarioDetailDialogBinding.inflate(inflater,container,false)
        var view = binding.root
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val products = arguments?.getSerializable("product") as productd

        binding.tvNameProduct.text = products.nombre
//        binding.tvDescriptionProduct.text = products.detail
        binding.tvPriceProduct.text = products.precio
        Picasso.get().load(products.url).into(binding.ivProduct)

        binding.guardar.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

}