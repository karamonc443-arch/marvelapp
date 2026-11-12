package educa.iesam.marvelapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.*
import educa.iesam.marvelapp.core.cache.AppCacheTimeToLive
import educa.iesam.marvelapp.core.serialization.GsonJsonSerialiazer
import educa.iesam.marvelapp.core.time.LocalAppTime
import educa.iesam.marvelapp.features.superheroes.data.local.xml.SuperHeroLocalDataSourceRepository
import educa.iesam.marvelapp.features.superheroes.data.local.xml.SuperHeroXmlLocalDataSource
import educa.iesam.marvelapp.features.superheroes.domain.GetSuperHeroesUseCase
import educa.iesam.marvelapp.features.superheroes.domain.SuperHero
import educa.iesam.marvelapp.features.superheroes.presentation.SuperHeroListVewModel

class MainActivity : AppCompatActivity() {
    val useCase = GetSuperHeroesUseCase(
        SuperHeroLocalDataSourceRepository(
            SuperHeroXmlLocalDataSource(
                this,
                GsonJsonSerialiazer.create(),
                AppCacheTimeToLive(this, LocalAppTime())
            )
        )
    )
    private val viewModel : SuperHeroListVewModel by viewModels {
        SuperHeroListVewModel.factory(useCase)
    }
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
              return renderUi(superHeroes.first())
            }
        }

    }
    private fun renderUi(superHero: SuperHero){
        val superHeroLayout = findViewById<ConstraintLayout>(R.id.superhero_layout)

        val labelNameSuperHero = superHeroLayout.findViewById<TextView>(R.id.superhero_name)
        labelNameSuperHero.text = superHero.name

        val labelSlugSuperHero = superHeroLayout.findViewById<TextView>(R.id.superhero_slug)
        labelSlugSuperHero.text = superHero.slug
    }
}