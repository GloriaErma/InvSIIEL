package com.misiontic2022.inventariosiiel.view.ui.fragments

import Data.DBHelper
import Data.Tables
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.misiontic2022.inventariosiiel.databinding.FragmentUsuarioDetailDialogBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UsuarioDetailDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UsuarioDetailDialogFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentUsuarioDetailDialogBinding? = null
    private val binding get() = _binding!!
    lateinit var informacionDBHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        informacionDBHelper = DBHelper(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_usuario_detail_dialog, container, false)
        _binding = FragmentUsuarioDetailDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UsuarioDetailDialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UsuarioDetailDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
        // Paso 10. COnfiguración almacenamiento valores.
        binding.guardar.setOnClickListener {

            if (binding.etNameAdmin.text.isNotBlank() &&
                binding.etAddressAdmin.text.isNotBlank() &&
                binding.etMailAdmin.text.isNotBlank() &&
                binding.etPhoneAdmin.text.isNotBlank()
            ) {
                informacionDBHelper.edit(
                    binding.etNameAdmin.text.toString(),
                    binding.etAddressAdmin.text.toString(),
                    binding.etMailAdmin.text.toString(),
                    binding.etPhoneAdmin.text.toString()
                )

                // Paso 11. limpiando los campos editables
                Toast.makeText(activity, "Transacción Guardar EXITOSA", Toast.LENGTH_LONG).show()

                binding.etNameAdmin.text.clear()
                binding.etAddressAdmin.text.clear()
                binding.etMailAdmin.text.clear()
                binding.etPhoneAdmin.text.clear()
            } else {
                Toast.makeText(activity, "** ERROR AL GUARDAR ", Toast.LENGTH_LONG).show()
            }
        }

        // Paso 12.ACtualizar datos
        val db : SQLiteDatabase = informacionDBHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM " + Tables.information.TABLE_NAME,null)
        if (cursor == null) {
            Toast.makeText(activity, "** BASE de DATOS VACIA", Toast.LENGTH_LONG).show()
        }
        if(cursor.moveToFirst()) {
            do {
                binding.etNameAdmin.setText(cursor.getString(1).toString())
                binding.etAddressAdmin.setText(cursor.getString(2).toString())
                binding.etPhoneAdmin.setText(cursor.getString(3).toString())
                binding.etMailAdmin.setText(cursor.getString(4).toString())
            } while (cursor.moveToNext())
        }

    }
}