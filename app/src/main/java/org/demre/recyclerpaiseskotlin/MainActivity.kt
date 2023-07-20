package org.demre.recyclerpaiseskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.demre.recyclerpaiseskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
    }
    private fun initAdapter() {
        val adapter = Adapter()
        val sudamerica = PaisSudan.getPaisSudan()
        adapter.setData(sudamerica)
        binding.rVpaises.adapter=adapter

    }
}