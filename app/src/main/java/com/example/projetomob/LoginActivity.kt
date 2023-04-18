package com.example.projetomob

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetomob.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBindig.inflate(layoutInflater)
        setContentView(binding.root)






        supportActionBar!!.hide()

        binding.Btlogin.setOnClickListener {

            val nome = binding.editNome.text.toString()
            val senha = binding.editSenha.text.toString()

            when{
                nome.isEmpty() -> {
                    mensagem(it,"Coloque seu nome aqui!")
                }senha.isEmpty() -> {
                    mensagem(it,"Preencha a senha!")
                }senha.lenght <=5 -> {
                    mensagem(it,"A senha precisa ter pelo menos 6 caracteres!")
                }else -> {
                    irParaHome(nome)
                }
            }
        }
    }

    private fun mensagem(view: view, mensagem: String){
        val snackbar = Snackbar.make(view,mensagem,Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#fb573b"))
        snackbar.setTextColor(Color.parseColor("#FFFFFFFF"))
        snackbar.show
    }
    private fun irParaHome(nome: string){
        val intent = intent(this,Home::class.java)
        intent.putExtra("nome",nome)
        startActivity(intent)
    }

}
