package fish.app.models

import java.util.*
import javax.persistence.*


@Entity()
@Table(name = "fishes")
class Fish{
    @Id
    @GeneratedValue
    private val id : Long? = null
    @Column(name="weight")
    private val weight : Double? = null
    @Column(name="length")
    private val length : Double? = null
    @Column(name="x")
    private val x : Double? = null
    @Column(name="y")
    private val y : Double? = null
    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private val date : Date? = null
    @ManyToOne
    @JoinColumn(name="id_user", referencedColumnName = "id")
    private var user: User? = null
    @ManyToOne()
    @JoinColumn(name="id_species", referencedColumnName="id")
    private var species: Species? = null


    override fun toString(): String {
        return "Fish{\n" +
                "   id: $id,\n" +
                "   weight: $weight,\n" +
                "   user: ${user.toString()},\n" +
                "   species: $species,\n" +
                "}\n"
    }
}