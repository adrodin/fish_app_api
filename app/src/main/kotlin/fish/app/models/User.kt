package fish.app.models

import javax.persistence.*


@Entity
@Table(name = "users")
class User(
    private var name: String,
    private var email: String,
    private var password: String
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null
    @OneToMany (mappedBy = "user")
    private var fishList: List<Fish>? = null
    @OneToOne(mappedBy = "user")
    private var apiKey: ApiKey? = null

    constructor(id: Long, name: String,email: String,password: String) : this(name,email,password) {
        this.id = id
    }

    override fun toString(): String {
        return "User{\n" +
                "   name: $name,\n" +
                "}\n"

    }

    fun getId(): Long? {
        return id
    }
    fun getName(): String{
        return name
    }
    fun getEmail():String{
        return email
    }
    fun getPassword():String{
        return password
    }

    fun getApiKey(): ApiKey? {
        return this.apiKey
    }

    fun setID(id:Long){
        this.id = id
    }
    fun setName(name:String){
        this.name = name
    }
    fun setEmail(email: String){
        this.email = email
    }
    fun setPassword(password: String){
        this.password = password
    }
}



