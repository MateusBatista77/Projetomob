package com.example.projetomob;

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.projetomob.model.TreinadorModelo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class TelaCadastro : AppCompatActivity() {

    private lateinit var Btncad: Button
    private lateinit var Btnacess: Button
    private lateinit var Camponome: EditText
    private lateinit var Camposobrenome: EditText



    private lateinit var dbReference: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro)
        val firebase: DatabaseReference = FirebaseDatabase.getInstance().getReference()

        Btncad = findViewById(R.id.Btncad)
        Btnacess = findViewById(R.id.Btnacess)
        Camponome = findViewById(R.id.Camponome)
        Camposobrenome = findViewById(R.id.Camposorenome)

        dbReference = FirebaseDatabase.getInstance().getReference("Treinadores")

        Btncad.setOnClickListener{
            cadastrarTreinador()
        }

        Btnacess.setOnClickListener{
            val intent = Intent(this, ListaTreinador::class.java)
            startActivity(intent)
        }


    }

    private fun cadastrarTreinador(){

        //pegar valores
        val nomeTreinador = Camponome.text.toString()
        val sobrenomeTreinador = Camposobrenome.text.toString()

        if (nomeTreinador.isEmpty()){
            Camponome.error = "Preencha com um nome"
        }

        if (sobrenomeTreinador.isEmpty()){
            Camposobrenome.error = "Preencha com um sobrenome"
        }

        val treiId = dbReference.push().key!!

        val treinador = TreinadorModelo(treiId, nomeTreinador, sobrenomeTreinador)

        dbReference.child(treiId).setValue(treinador)
            .addOnCompleteListener{
                Toast.makeText(this, "Treinador Cadastrado", Toast.LENGTH_LONG).show()

                Camponome.text.clear()
                Camposobrenome.text.clear()


            }.addOnFailureListener{ err ->
                Toast.makeText(this, "Erro ${err.message}", Toast.LENGTH_LONG).show()
            }
    }

}