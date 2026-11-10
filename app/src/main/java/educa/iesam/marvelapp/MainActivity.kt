package educa.iesam.marvelapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import educa.iesam.marvelapp.features.superheroes.presentation.SuperHeroListVewModel

class MainActivity : AppCompatActivity() {
    private val viewModel : SuperHeroListVewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d("MainActivity", "OnCreate")
        initObserver()
        viewModel.loadSuperHeroes()
    }
    private fun initObserver(){
        viewModel.uiState.observe(this){ uiState ->
            Log.d("MainActivity",uiState.isLoading.toString())
            bind(uiState)
        }
    }
    private fun bind(uiState: SuperHeroListVewModel.UiState) {
        if (uiState.isLoading) {

        } else {

        }
        if (uiState.hasError) {

        } else {
        }
        uiState.superHeroes?.let { superHeroes ->
            if (superHeroes.isEmpty()){

            }else{

            }
        }
    }
}