package com.example.ejercicio_14_m5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejercicio_14_m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var saldo = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonOk.setOnClickListener{
            when  (binding.radioGroup.checkedRadioButtonId){
                R.id.radioButtonSaldo ->
                    binding.editTextMonto.setText(saldo.toString())
                R.id.radioButtonIngresar -> ingresarMonto()
                R.id.radioButtonRetirar -> retirarSaldo()
                R.id.radioButtonSalir -> finish()

            }
        }





    }
    private fun retirarSaldo(){
       val monto = binding.editTextMonto.toString().toInt()
        if (monto<=saldo) {
            saldo -= monto
            limpiarMonto()

            crearMensaje("El retiro ha sido exitoso")
        }
        else {
            crearMensaje("El monto supera su saldo, por favor ingrese un monto valido")
        }
    }


    fun ingresarMonto(){
    saldo += saldo + binding.editTextMonto.text.toString().toInt()
        limpiarMonto()
    crearMensaje("Su saldo ha sido actualizado")



}
    fun limpiarMonto(){
        binding.editTextMonto.text.clear()
    }
    fun crearMensaje(s:String){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show()

    }
}