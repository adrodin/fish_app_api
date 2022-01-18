package fish.app.repositories

import fish.app.models.ApiKey
import fish.app.models.User
import org.springframework.data.repository.CrudRepository

interface ApiKeyRepository: CrudRepository<ApiKey, Long> {
    fun findByUser(user: User): ApiKey?
    fun findByKey(key:String): ApiKey?
}