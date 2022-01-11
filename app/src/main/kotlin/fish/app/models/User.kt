package fish.app.models

import javax.persistence.*


@Entity()
@Table(name = "users")
class User(
    @Id
    @GeneratedValue
    private var id: Long,
    private var name: String,
    private var email: String,
    private var password: String
){
    @OneToMany (mappedBy = "user")
    private var fieschesList: List<Fish>? = null
    @OneToOne(mappedBy = "user")
    private var apiKey: ApiKey? = null

    override fun toString(): String {
        return "User{\n" +
                "   id: $id,\n" +
                "   name: $name,\n" +
                "   email: $email,\n" +
                "   password: $password,\n" +
                "}\n"

    }

    fun getId(): Long {
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


//    @ManyToMany
//    @JoinTable(
//        name = "post_tag",
//        joinColumns = [JoinColumn(name = "post_id")],
//        inverseJoinColumns = [JoinColumn(name = "tag_id")]
//    )


