package fish.app.repositories

import fish.app.models.Species
import org.springframework.data.repository.CrudRepository

interface SpeciesRepository: CrudRepository<Species, Long> {
    fun findByName(name:String): Species?
}