package educa.iesam.marvelapp.features.superheroes.domain

class GetSuperHeroUseCase(private val superHeroRepository: SuperHeroRepository) {
    operator fun invoke(id: String): SuperHero?{
        return superHeroRepository.getById(id)
    }
}