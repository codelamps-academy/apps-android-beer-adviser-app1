package com.blackspring.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.blackspring.beeradviser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val findBeer = findViewById<Button>(R.id.btn_find_beer)
        binding.btnFindBeer.setOnClickListener {
//            val beerColor = findViewById<Spinner>(R.id.beer_color)
            val color = binding.beerColor.selectedItem

            val beerList = getBeers(color.toString())
            val beers = beerList.reduce { str, item -> str + "||" + item }

//            val brands = findViewById<TextView>(R.id.brands)
            binding.brands.text = beers
        }
    }

    fun getBeers(color: String): List<String> {
        return when (color) {
            "Light" -> listOf("Jail Pale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }
}