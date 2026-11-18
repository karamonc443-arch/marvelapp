package educa.iesam.marvelapp.features.superheroes.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import educa.iesam.marvelapp.R
import educa.iesam.marvelapp.features.superheroes.domain.SuperHero

class SuperHeroAdapter : ListAdapter<SuperHero, SuperHeroListViewHolder>(DifCallBack) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuperHeroListViewHolder {
      val view =  LayoutInflater.from(parent.context)
          .inflate(R.layout.view_superhero_item,parent,false)
        return SuperHeroListViewHolder(view)


    }

    override fun onBindViewHolder(
        holder: SuperHeroListViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
    //Patrón singletón "DifCallBack"
    object DifCallBack: DiffUtil.ItemCallback<SuperHero>(){
        override fun areItemsTheSame(
            oldItem: SuperHero,
            newItem: SuperHero
        ): Boolean {
          return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: SuperHero,
            newItem: SuperHero
        ): Boolean {
           return oldItem == newItem
        }

    }
}