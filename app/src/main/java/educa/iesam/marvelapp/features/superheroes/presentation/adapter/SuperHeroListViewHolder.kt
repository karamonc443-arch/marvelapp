package educa.iesam.marvelapp.features.superheroes.presentation.adapter

import android.view.View
import android.widget.TextView

import educa.iesam.marvelapp.R
import androidx.recyclerview.widget.RecyclerView
import educa.iesam.marvelapp.features.superheroes.domain.SuperHero

class SuperHeroListViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun bind(superHero: SuperHero){
       view.findViewById<TextView>(R.id.superhero_name).text = superHero.name
       view.findViewById<TextView>(R.id.superhero_slug).text = superHero.slug
    }
}