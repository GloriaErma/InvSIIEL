package Data

import android.app.Person

class Tables {

    abstract class information{
        companion object {
            val TABLE_NAME= "Info"
            val _id = "_id"
            val _nombre = "Name"
            val _Direccion = "Address"
            val _telefono = "Phone"
            val _correo = "Email"
            var persons: MutableList<Person> = ArrayList()
        }
    }
}