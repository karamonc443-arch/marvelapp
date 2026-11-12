package educa.iesam.marvelapp.features.superheroes.domain
interface SuperHeroRepository {
    fun getAll(): List<SuperHero>
    fun getById(id: String): SuperHero?
}
