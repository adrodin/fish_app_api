package fish.app.services

import fish.app.models.ApiKey
import fish.app.models.User
import fish.app.repositories.ApiKeyRepository
import fish.app.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*
import java.util.regex.Pattern


@Service
class UserService {
    @Autowired
    private var userRepository: UserRepository? = null
    @Autowired
    private var apiKeyRepository: ApiKeyRepository? = null

    fun registry(name: String, password: String, email: String): String?{
        if(!emailValidator(email)){
            return "Invalid email"
        }
        if (userRepository?.findByName(name) != null){
            return "User with this name already exist"
        }
        if (userRepository?.findByEmail(email) != null){
            return "User with this email already exist"
        }
        val user = User(name,email,password)
        userRepository?.save(user)
        val apiKey = ApiKey(UUID.randomUUID().toString().subSequence(0,30).toString(),user)
        apiKeyRepository?.save(apiKey)
        return "Account created: {name: $name, password: $password, email: $email, apiKey: $apiKey}"
    }

    fun getApiKey(name: String, password: String): String{
        val user = userRepository?.findByName(name)
        if (user != null){
            if (user.getPassword() != password){
                return "User with this name and password does not exist"
            }
            return "{api key: "+apiKeyRepository?.findByUser(user)?.getKey().toString()+"}"
        }
        return "User with this name and password does not exist"
    }

    fun updateUser(email: String,password: String, apiKey:String):String{
        if(!emailValidator(email)){
            return "Invalid email"
        }
        val user = apiKeyRepository?.findByKey(apiKey)?.getUser() ?: return "Wrong api key"
        if( userRepository?.findByEmail(email) != null) return "User with this email already exist"
        if(email != "-1") user.setEmail(email)
        if(password != "-1") user.setPassword(password)
        userRepository?.save(user)
        return "Profile updated"
    }



    private fun emailValidator(email: String):Boolean{
        val regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"
        return Pattern.compile(regexPattern).matcher(email).matches()
    }



}