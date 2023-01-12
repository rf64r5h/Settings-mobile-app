package com.example.settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.preference.PreferenceManager
import com.example.settings.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Executa a função mySettings que foi criada abaixo
        mySettings()
    }

   //Função que pega o método getDefaultSharedPreferences do android que cuida da manipulação de preferências 
    private fun mySettings() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this) //Pega as preferencias
        val username = prefs.getString("username", "") // Pega o valor de username, que é setado nas configurações, caso não tenha nenhum nome ficará vazio 
        val switch = prefs.getBoolean("block", true) // Pega o valor do switch da configuração, mas não foi implementado
        val hello = "Olá "

        binding.apply {
            tvUsername.text = hello + username // Mensagem que é exibida na tela inicial ( hello = Olá, username = o username que foi passado nas configurações

        }

    }

    // Esse método cria o menu (3 pontinhos no canto superior direito da tela inicial), quando clicado aparece a opção configuração
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //Método que é executado quando a opção configuração for clicada, ele faz o redericionamento para a página(Activity) de configuração
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}