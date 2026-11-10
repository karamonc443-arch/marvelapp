package educa.iesam.marvelapp.features.superheroes.data.local.xml

import educa.iesam.marvelapp.features.superheroes.domain.SuperHero
import educa.iesam.marvelapp.features.superheroes.domain.SuperHeroRepository

class SuperHeroLocalDataSourceRepository(private val xmlLocalDataSource: SuperHeroXmlLocalDataSource) :
    SuperHeroRepository {
    override fun getAll(): List<SuperHero> {
        return xmlLocalDataSource.findAll()
    }
}