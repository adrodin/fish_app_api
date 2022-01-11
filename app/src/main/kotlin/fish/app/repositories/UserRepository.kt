package fish.app.repositories

import fish.app.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


interface UserRepository:CrudRepository<User, Long> {
    fun findByName(name: String): User?
}