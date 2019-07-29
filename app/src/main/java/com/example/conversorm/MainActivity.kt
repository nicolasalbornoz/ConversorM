package com.example.conversorm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mon1 = ""
    private var mon2 = ""
    private var punto:Boolean = true
    private var temporal = ""
    var temporal1:Double = 0.0
    var conversion:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val monedas1 = arrayOf("Peso colombiano","Dolar","Peso mexicano","Euro")
        val monedas2 = arrayOf("Dolar","Peso colombiano","Peso mexicano","Euro")

        val adapter1 = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, monedas1
        )

        val adapter2 = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, monedas2
        )

        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        spMoneda1.adapter = adapter1
        spMoneda2.adapter = adapter2

        spMoneda1.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                mon1 = "${parent.getItemAtPosition(position).toString()}"
            }
        }

        spMoneda2.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                mon2 = "${parent.getItemAtPosition(position).toString()}"
            }
        }

        ////////////////////// Ingresar datos con los botones

        bt_0.setOnClickListener { agregar_numero("0")}
        bt_1.setOnClickListener { agregar_numero("1")}
        bt_2.setOnClickListener { agregar_numero("2")}
        bt_3.setOnClickListener { agregar_numero("3")}
        bt_4.setOnClickListener { agregar_numero("4")}
        bt_5.setOnClickListener { agregar_numero("5")}
        bt_6.setOnClickListener { agregar_numero("6")}
        bt_7.setOnClickListener { agregar_numero("7")}
        bt_8.setOnClickListener { agregar_numero("8")}
        bt_9.setOnClickListener { agregar_numero("9")}
        bt_punto.setOnClickListener { agregar_punto(".",punto)}

        //// Borrar_todo

        bt_borrar.setOnClickListener {
            tvMoneda1.text=""
            tvMoneda2.text=""
            punto= true
        }

        //// Calcular

        bt_calcular.setOnClickListener {

            if(tvMoneda1.text == ""){
                Toast.makeText(
                    this, "Por favor digite el valor que desea convertir",
                    Toast.LENGTH_LONG
                ).show();
            }
            else {
                when (mon1) {

                    "Peso colombiano" -> {
                        when (mon2) {

                            "Peso colombiano" -> {
                                tvMoneda2.text = tvMoneda1.text
                            }

                            "Dolar" -> {
                                temporal = tvMoneda1.text.toString()
                                temporal1 = temporal.toDouble()
                                conversion = temporal1 / 3175
                                tvMoneda2.text = conversion.toString()
                            }

                            "Peso mexicano" -> {
                                temporal = tvMoneda1.text.toString()
                                temporal1 = temporal.toDouble()
                                conversion = temporal1 / 166
                                tvMoneda2.text = conversion.toString()
                            }
                            else -> {
                                temporal = tvMoneda1.text.toString()
                                temporal1 = temporal.toDouble()
                                conversion = temporal1 / 3560
                                tvMoneda2.text = conversion.toString()
                            }
                        }
                    }

                    "Dolar" -> {
                        when (mon2) {

                            "Dolar" -> {
                                tvMoneda2.text = tvMoneda1.text
                            }
                            "Peso colombiano" -> {
                                temporal = tvMoneda1.text.toString()
                                temporal1 = temporal.toDouble()
                                conversion = temporal1 * 3175
                                tvMoneda2.text = conversion.toString()
                            }

                            "Peso mexicano" -> {
                                temporal = tvMoneda1.text.toString()
                                temporal1 = temporal.toDouble()
                                conversion = temporal1 * 19.06
                                tvMoneda2.text = conversion.toString()
                            }
                            else -> {
                                temporal = tvMoneda1.text.toString()
                                temporal1 = temporal.toDouble()
                                conversion = temporal1 * 0.89
                                tvMoneda2.text = conversion.toString()
                            }
                        }
                    }

                    "Peso mexicano" -> {
                        when (mon2) {

                            "Peso mexicano" -> {
                                tvMoneda2.text = tvMoneda1.text
                            }
                            "Peso colombiano" -> {
                                temporal = tvMoneda1.text.toString()
                                temporal1 = temporal.toDouble()
                                conversion = temporal1 * 166
                                tvMoneda2.text = conversion.toString()
                            }

                            "Dolar" -> {
                                temporal = tvMoneda1.text.toString()
                                temporal1 = temporal.toDouble()
                                conversion = temporal1 * 19.06
                                tvMoneda2.text = conversion.toString()
                            }
                            else -> {
                                temporal = tvMoneda1.text.toString()
                                temporal1 = temporal.toDouble()
                                conversion = temporal1 * 0.047
                                tvMoneda2.text = conversion.toString()
                            }
                        }
                    }

                    else -> {
                        when (mon2) {

                            "Euro" -> {
                                tvMoneda2.text = tvMoneda1.text
                            }
                            "Peso colombiano" -> {
                                temporal = tvMoneda1.text.toString()
                                temporal1 = temporal.toDouble()
                                conversion = temporal1 * 3560
                                tvMoneda2.text = conversion.toString()
                            }

                            "Peso mexicano" -> {
                                temporal = tvMoneda1.text.toString()
                                temporal1 = temporal.toDouble()
                                conversion = temporal1 * 21.38
                                tvMoneda2.text = conversion.toString()
                            }
                            else -> {
                                temporal = tvMoneda1.text.toString()
                                temporal1 = temporal.toDouble()
                                conversion = temporal1 * 1.12
                                tvMoneda2.text = conversion.toString()
                            }
                        }
                    }
                }
            }
        }

    }

    fun agregar_numero (string: String){

        tvMoneda1.append(string)
        punto = false
    }

    fun agregar_punto (string: String,punt:Boolean){

        if(!punt){

            tvMoneda1.append(string)
            punto = true
        }
        else{

        }

    }
}
