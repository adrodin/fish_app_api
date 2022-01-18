package fish.app.models

import javax.persistence.*

@Entity
@Table(name="apikeys")
class ApiKey(key: String) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null
    @Column(name="key")
    private var key: String? = key
    @OneToOne
    @JoinColumn(name="id_user", referencedColumnName = "id")
    private var user : User? = null

    constructor(key: String, user:User) : this(key) {
        this.user = user
    }

    fun getKey(): String? {
        return key
    }
    fun getUser():User?{
        return user
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other is ApiKey) return false

        other as ApiKey

        if (key != other.key) return false

        return true
    }

    override fun hashCode(): Int {
        return key?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "apiKey: $key"
    }

}