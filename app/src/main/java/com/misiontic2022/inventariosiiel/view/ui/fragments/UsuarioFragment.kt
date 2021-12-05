package com.misiontic2022.inventariosiiel.view.ui.fragments

import Data.DBHelper
import Data.Tables
import Data.Tables.information.Companion._Direccion
import Data.Tables.information.Companion._correo
import Data.Tables.information.Companion._nombre
import Data.Tables.information.Companion._telefono
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.misiontic2022.inventariosiiel.R
import com.misiontic2022.inventariosiiel.databinding.FragmentUsuarioBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [UsuarioFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UsuarioFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
//    private var _binding: FragmentAdminBinding? = null
    private var _binding: FragmentUsuarioBinding? = null
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.editar)
        button?.setOnClickListener {
            findNavController().navigate(R.id.usuarioDetailFragmentDialog, null)
        }

        Log.d("UsuarioFragment", "******UsuarioFragment.....")

        //Paso 13. actualizar los valores de los datos de
        //usuario en el fragmento AdminFragment
        val db : SQLiteDatabase = informacionDBHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM " + Tables.information.TABLE_NAME,null)
//
//        val msg = "*****Username Ingresado:  ${cursor.getString(1).toString()}, Direcion Ingresado:  ${cursor.getString(2).toString()}"
//        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
//        Log.d("UsuarioFragment", "******uuuuuuuuuuuuuuuuuuuuUsuarioFragment.....")

        if (cursor == null) {
            Toast.makeText(activity, "** BASE de DATOS VACIA", Toast.LENGTH_LONG).show()
        }
        if(cursor.moveToFirst()){
            do{
                Toast.makeText(activity, "***** que pasa DIOS", Toast.LENGTH_LONG).show()
                Log.d("UsuarioFragment", "******ccccccccursoooorrrrrrrrrr.....")
                //val msg = "Username Ingresado:  ${usuario.text}, Password Ingresado:  ${Password.text}"
                //Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
                val msg = "*****Username Ingresado:  ${getString(cursor.getColumnIndex(_nombre))}, Direcion Ingresado:  ${getString(cursor.getColumnIndex(_nombre))}"
                Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()

//                binding.tvNameAdmin.setText("Nombre: " + cursor.getString(1).toString() )
//                binding.tvAddressAdmin.setText("Dirección: " + cursor.getString(2).toString() )
//                binding.tvPhoneAdmin.setText("Telefono: " + cursor.getString(3).toString())
//                binding.tvMailAdmin.setText("Correo: " + cursor.getString(4).toString() )
                binding.tvNameAdmin.setText("Nombre: " + (cursor.getColumnIndex(_nombre)) )
                binding.tvAddressAdmin.setText("Dirección: " + (cursor.getColumnIndex(_Direccion)) )
                binding.tvPhoneAdmin.setText("Telefono: " + (cursor.getColumnIndex(_telefono)) )
                binding.tvMailAdmin.setText("Correo: " + (cursor.getColumnIndex(_correo)) )

            }while (cursor.moveToNext())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_usuario, container, false)
        _binding = FragmentUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UsuarioFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UsuarioFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}