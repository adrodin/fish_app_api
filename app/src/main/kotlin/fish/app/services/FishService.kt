package fish.app.services

import fish.app.models.Fish
import fish.app.models.Species
import fish.app.repositories.ApiKeyRepository
import fish.app.repositories.FishRepository
import fish.app.repositories.SpeciesRepository
import fish.app.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.sql.Date

@Service
class FishService {

    @Autowired
    private var userRepository: UserRepository? = null
    @Autowired
    private var fishRepository: FishRepository? = null
    @Autowired
    private var speciesRepository: SpeciesRepository? = null
    @Autowired
    private var apiKeyRepository: ApiKeyRepository? = null

    fun addFish(apiKey: String,
                speciesName: String,
                weight:Double,length:Double,
                x:Double,
                y:Double,
                date:Date
    ): String? {
        val user = apiKeyRepository?.findByKey(apiKey)?.getUser()
        if(user != null){
            var species = speciesRepository?.findByName(speciesName)
            if( species == null){
                species = Species(speciesName)
                speciesRepository?.save(species)
            }
            val fish = Fish(weight,length,x,y,date,user,species)
            fishRepository?.save(fish)
            return "Fish added \n" +
                    "Fish: $fish"
        }
        return "Invalid api key"
    }

    fun findFish(id: Long): String {
        val fish = fishRepository?.findById(id)
        if (fish!!.isEmpty){
            return "Fish with id $id not exist"
        }
        return fish.get().toString()


    }

    fun getUserFish(name: String): String{
        val user = userRepository?.findByName(name) ?: return "User not exist "

        val fishes = fishRepository?.findByUser(user)
        return fishes.toString()
    }


    fun updateFish(id:Long, length: Double, weight:Double,apiKey:String):String{
        val fish = fishRepository?.findById(id)
        if (fish!!.isEmpty){
            return "Invalid fish ID"
        }
        val newFish = fish.get()

        if(newFish.getUser()?.getApiKey()?.getKey() != apiKey){
            return "Invalid api key"
        }

        if(length>0){
            newFish.setLength(length)
        }
        if(weight>0){
            newFish.setWeight(weight)
        }
        fishRepository?.save(newFish)
        return "Fish updated"
    }


    fun deleteFish(fishId: Long, userKey: String):String{
        val fish = fishRepository?.findById(fishId)
        if (fish!!.isEmpty){
            return "Invalid fish ID"
        }
        val newFish = fish.get()

        if(newFish.getUser()?.getApiKey()?.getKey() != userKey){
            return "Invalid api key"
        }

        fishRepository?.delete(newFish)
        return "Fish deleted"
    }
}