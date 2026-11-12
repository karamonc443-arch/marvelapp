package educa.iesam.marvelapp.features.superheroes.data.local

import educa.iesam.marvelapp.features.superheroes.data.local.xml.SuperHeroXmlLocalDataSource
import educa.iesam.marvelapp.features.superheroes.data.remote.mock.SuperHeroMockRemoteDataSource
import educa.iesam.marvelapp.features.superheroes.domain.SuperHero
import educa.iesam.marvelapp.features.superheroes.domain.SuperHeroRepository

class SuperHeroLocalDataSourceRepository(private val xmlLocalDataSource: SuperHeroXmlLocalDataSource, private val remoteDataSource: SuperHeroMockRemoteDataSource) :
    SuperHeroRepository {
    override fun getAll(): List<SuperHero> {
        return xmlLocalDataSource.findAll()
    }

    override fun getById(id: String): SuperHero? {
        return xmlLocalDataSource.findById(id)
    }

    override fun update(superHero: SuperHero) {
        xmlLocalDataSource.save(remoteDataSource.obtainAll())
        xmlLocalDataSource.update(superHero)
    }
}