package educa.iesam.marvelapp.features.superheroes.data.remote.mock

import educa.iesam.marvelapp.features.superheroes.domain.SuperHero

class SuperHeroMockRemoteDataSource {
    fun obtainAll() : List<SuperHero>{
        return listOf(
            SuperHero("1","Nombre 1","Slug 1","https://1"),
            SuperHero("2","Nombre 2","Slug 2","https://2"),
            SuperHero("3","Nombre 3","Slug 3","https://3"),
            SuperHero("4","Nombre 4","Slug 4","https://4")
        )
    }
}