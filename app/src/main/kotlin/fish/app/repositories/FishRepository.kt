package fish.app.repositories

import fish.app.models.Fish
import fish.app.models.Species
import fish.app.models.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface FishRepository: JpaRepository<Fish, Long> {
    fun findByUser(user: User): List<Fish>
    fun findBySpecies(species: Species): List<Fish>
    fun findByDateBetweenAndSpecies(dateStart: Date, dateEnd: Date, species: Species): List<Fish>
    fun findByDateBetween(dateStart: Date, dateEnd: Date): List<Fish>
}