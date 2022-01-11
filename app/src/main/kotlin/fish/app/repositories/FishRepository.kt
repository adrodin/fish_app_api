package fish.app.repositories

import fish.app.models.Fish
import fish.app.models.User
import org.springframework.data.repository.CrudRepository

interface FishRepository: CrudRepository<Fish, Long> {
    fun findByUser(user: User): List<Fish>
}