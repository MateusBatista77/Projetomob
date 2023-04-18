package com.example.projetomob.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projetomob.R
import com.example.projetomob.adapter.AcademiaAdapter
import com.example.projetomob.databinding.ActivityHomeBinding


class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var AcademiaAdapter: AcademiaAdapter
    private val listaAcademia: MutableList<Academias> = mutableListOf()

     override override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome")

        binding.textNomeUsuario.text = "Bem-vindo,$nome"
         val recyclerViewAcademia = binding.recyclerViewAcademias
         recyclerViewAcademia.layoutManager = GridLayoutManager(this,2)
         AcademiaAdapter = AcademiaAdapter(this,listaAcademia)
         recyclerViewAcademia.setHasFixedSize(true)
         recyclerViewAcademia.adapter = AcademiaAdapter
         getAcademias()

         binding.BtProximo.setOnClickListener {
             val intent = intent(this,Agendamento::class.java)
             intent.putExtra("nome",nome)
             startActivity(intent)
         }

    }


private fun getAcademias(){

    val academia1 = Academias(R.drawable.img1,"Academia Dorado")
    listaAcademia.add(academia1)

    val academia2 = Academias(R.drawable.img2,"Academia Strong")
    listaAcademia.add(academia2)

    val academia3 = Academias(R.drawable.img3,"Academia Azul-Marine")
    listaAcademia.add(academia3)

    val academia4 = Academias(R.drawable.img4,"Academia I9")
    listaAcademia.add(academia4)


    }
}
