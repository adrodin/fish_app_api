package fish.app.models

import javax.persistence.*

@Entity
@Table(name="species")
class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null
    @Column(name="name")
    private var name: String? = null
    @OneToMany(mappedBy = "species")
    private var fishes: List<Fish>? = null
    override fun toString(): String {
        return "Species{\n" +
                "   name: $name,\n" +
                "}\n"
    }
    constructor(name: String){
        this.name = name
    }
    fun getName(): String? {
        return name
    }
}