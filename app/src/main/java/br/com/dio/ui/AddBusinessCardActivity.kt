package br.com.dio.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.dio.App
import br.com.dio.R
import br.com.dio.data.BusinessCard
import br.com.dio.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel:MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnContinuar.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.txtImputNome.editText?.text.toString(),
                telefone = binding.txtImputTelefone.editText?.text.toString(),
                email = binding.txtImputEmail.editText?.text.toString(),
                empresa = binding.txtImputEmpresa.editText?.text.toString(),
                cor = binding.txtImputCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}

