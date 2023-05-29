package com.example.projetomob

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetomob.adapter.treinadorAdapt
import com.example.projetomob.model.TreinadorModelo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ListaTreinador : AppCompatActivity() {

    private lateinit var treiRecyclerView: RecyclerView
    private lateinit var tvLoadingDat: TextView
    private lateinit var treiList: ArrayList<TreinadorModelo>
    private lateinit var dbReference: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_treinador)

        tvLoadingDat = findViewById(R.id.Carregando)
        treiRecyclerView = findViewById(R.id.Recycler)
        treiRecyclerView.layoutManager = LinearLayoutManager(this)
        treiRecyclerView.setHasFixedSize((true))

        treiList = arrayListOf<TreinadorModelo>()

        getTreinadorData()

    }


    private fun getTreinadorData(){
        treiRecyclerView.visibility = View.GONE
        tvLoadingDat.visibility = View.VISIBLE

     dbReference = FirebaseDatabase.getInstance().getReference("Treinadores")

        dbReference.addValueEventListener(object :  ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                treiList.clear()
                if (snapshot.exists()) {
                    for (treiSnap in snapshot.children){
                        val treiData = treiSnap.getValue(TreinadorModelo::class.java)
                        treiList.add(treiData!!)
                    }
                    val mAdapter = treinadorAdapt(treiList)
                    treiRecyclerView.adapter = mAdapter

                    treiRecyclerView.visibility = View.VISIBLE
                    tvLoadingDat.visibility = View.GONE
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}