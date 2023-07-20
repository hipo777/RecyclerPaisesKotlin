package org.demre.recyclerpaiseskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.demre.recyclerpaiseskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Adapter.PaisCallback {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
    }
    private fun initAdapter() {
        val adapter = Adapter()
        adapter.setData(PaisSudan.paises)
        adapter.callback = this
        binding.rVpaises.adapter= adapter


    }

    override fun showCountry(texto: String) {
        binding.tVpaisSeleccionado.text = texto

    }
}