package fish.app.models

import javax.persistence.*

@Entity
@Table(name="apikeys")
class ApiKey {
    @Id
    @GeneratedValue
    private var id: Long? = null
    @Column(name="key")
    private var key: String? = null
    @OneToOne
    @JoinColumn(name="id_user", referencedColumnName = "id")
    private var user : User? = null

}