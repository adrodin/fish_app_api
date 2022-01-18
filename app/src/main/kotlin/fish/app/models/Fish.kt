package fish.app.models

import java.util.*
import javax.persistence.*

@Table(name = "fishes")
@Entity
class Fish{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id : Long? = null
    @Column(name="weight")
    private var weight : Double? = null
    @Column(name="length")
    private var length : Double? = null
    @Column(name="x")
    private var x : Double? = null
    @Column(name="y")
    private var y : Double? = null
    @Column(name="date")
    @Temporal(TemporalType.DATE)
    private var date : Date? = null
    @ManyToOne
    @JoinColumn(name="id_user", referencedColumnName = "id")
    private var user: User? = null
    @ManyToOne
    @JoinColumn(name="id_species", referencedColumnName="id")
    private var species: Species? = null

    constructor(weight: Double,length:Double, x:Double,y:Double,date:java.sql.Date,user:User,species: Species){
        this.weight = weight
        this.length = length
        this.x = x
        this.y = y
        this.date = date
        this.user = user
        this.species = species
    }

    fun setWeight(weight:Double){
        this.weight = weight
    }
    fun setLength(length:Double){
        this.length = length
    }
    fun getWeight(): Double? {
        return weight
    }
    fun getLength():Double?{
        return length
    }

    fun getUser(): User? {
        return user
    }
    override fun toString(): String {
        return "{" +
                "   id: $id,\n" +
                "   weight: $weight,\n" +
                "   length: $length,\n" +
                "   x: $x,\n" +
                "   y: $y,\n" +
                "   user: ${user?.getName()},\n" +
                "   species: ${species?.getName()}\n" +
                "}\n"
    }
}