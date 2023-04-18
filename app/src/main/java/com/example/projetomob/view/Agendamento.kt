package com.example.projetomob.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.example.projetomob.R
import com.example.projetomob.databinding.ActivityAgendamentoBinding
import java.util.Calendar


class Agendamento : AppCompatActivity() {

    private lateinit var binding: ActivityAgendamentoBinding
    private val calendar: Calendar = Calendar.getInstance()
    private var data: String = ""
    private var hora: String = ""


    @RequiresApi(Build.VERSION_CODES.O)
    override override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome").toString()

        val datePicker = binding.datePicker
        datePicker.setOnDateChangedListener { _, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_YEAR, dayOfMonth)

            var dia = dayOfMonth.toString()
            val mes: String

            if (dayOfMonth < 10) {
                dia = "0$dayOfMonth"
            }
            if (monthOfYear < 10) {
                mes = "" + (monthOfYear + 1)
            } else {
                mes = (monthOfYear + 1).toString
            }
            data = "$dia / $mes / $year"
        }
        
        binding.timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->

            val minuto: String

            if (minute < 10){
                minuto = "0$minute"
            }else{
                minuto = minute.toString()
            }

            hora = "$hourOfDay:$minuto"
        }
        binding.timePicker.setIs24HourView(true)

        binding.BtAgendar.setOnClickListener {

            val treinador1 = binding.Treinadore1
            val treinador2 = binding.Treinadore2
            val treinador3 = binding.Treinadore3

            when{
                hora.isEmpty() -> {
                    mensagem(it, "Preencha o horário!","#FF000000")
                }
                hora < "05:00" && hora > "00:00" -> {
                    mensagem(it, "Academia fechada - abertas de 06:00 ate 00:00!","#FF000000")
                }
                data.isEmpty() -> {
                    mensagem(it, "Selecione uma data!","#FF000000")
                }
                treinador1.isChecked && data.isNotEmpty() && hora.isNotEmpty() -> {
                    mensagem(it, "Agendamento realizado!","#fb573b")
                }
                treinador2.isChecked && data.isNotEmpty() && hora.isNotEmpty() -> {
                    mensagem(it, "Agendamento realizado!","#fb573b")
                }
                treinador3.isChecked && data.isNotEmpty() && hora.isNotEmpty() -> {
                    mensagem(it, "Agendamento realizado!","#fb573b")
                }
                else -> {
                    mensagem(it, "Escolha um treinador!","#FF000000")
                }
            }
        }
    }

    private fun mensagem(view: View, mensagem: String, cor: String){
        val sanckbar = snackbar.make(view,mensagem,snackbar.LENGHT_SHORT)
        snackbar.setBackgroundTint(Color.parseColor(cor))
        snackbar.seTextColor(Color.parseColor("##FFFFFFFF"))
        snackbar.show()
    }
}
