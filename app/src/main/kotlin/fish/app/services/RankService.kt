package fish.app.services

import fish.app.repositories.FishRepository
import fish.app.repositories.SpeciesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Date


@Service
class RankService {

    @Autowired
    private var fishRepository: FishRepository? = null
    @Autowired
    private var speciesRepository: SpeciesRepository? = null


    fun rank(species:String, dateStart:Date,dateEnd:Date,orderBy:String,num:Int): String? {

        if(orderBy!="length" && orderBy!="weight"){
            return "Invalid parametr"
        }

        if(species == "all"){
            if(orderBy == "weight"){
                return fishRepository?.findByDateBetween(dateStart,dateEnd)?.stream()?.
                sorted { o1, o2 -> (o1.getWeight()!!.compareTo(o2!!.getWeight()!!))*(-1) }?.
                limit(num.toLong())?.toList().toString()
            }
            return fishRepository?.findByDateBetween(dateStart,dateEnd)?.stream()?.
            sorted { o1, o2 -> (o1.getLength()!!.compareTo(o2!!.getLength()!!))*(-1) }?.
            limit(num.toLong())?.toList().toString()
        }

        val spc = speciesRepository?.findByName(species)
        if (spc != null) {
            if(orderBy == "weight"){
                return fishRepository?.findByDateBetweenAndSpecies(dateStart,dateEnd, spc)?.stream()?.
                sorted { o1, o2 -> (o1.getWeight()!!.compareTo(o2!!.getWeight()!!))*(-1) }?.limit(num.toLong())
                    ?.toList().toString()
            }
            return fishRepository?.findByDateBetweenAndSpecies(dateStart,dateEnd, spc)?.stream()?.
            sorted { o1, o2 -> (o1.getLength()!!.compareTo(o2!!.getLength()!!))*(-1) }?.limit(num.toLong())
                ?.toList().toString()

        }
        return "Invalid parametr"

    }


}