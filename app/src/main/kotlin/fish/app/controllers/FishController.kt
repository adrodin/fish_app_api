package fish.app.controllers

import fish.app.services.FishService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.sql.Date


@RestController
@RequestMapping("fish")
class FishController {

    @Autowired
    private val fishService: FishService? = null

    @PostMapping("/add")
    fun addFish(
        @RequestHeader("api-key", required = true) apiKey: String,
        @RequestParam("species-name", required = true) speciesName: String,
        @RequestParam("weight", required = true) weight:Double,
        @RequestParam("length", required = true)length:Double,
        @RequestParam("x", required = true)x:Double,
        @RequestParam("y", required = true)y:Double,
        @RequestParam("date", required = true)date: Date
    ): String? {
        return fishService?.addFish(apiKey, speciesName, weight, length, x, y, date)
    }

    @GetMapping("/get")
    fun getFish(
        @RequestParam("id", required = true) id:Long
    ): String {

        return fishService!!.findFish(id)
    }

    @GetMapping("/user")
    fun getUserFish(
        @RequestParam("name", required = true) name:String
    ): String? {
        return fishService?.getUserFish(name)
    }


    @PutMapping("/update")
    fun updateFish(
        @RequestHeader("api-key", required = true) apiKey: String,
        @RequestParam("id", required = true,) id:Long,
        @RequestParam("weight", defaultValue = "-1.0") weight: Double,
        @RequestParam("length", defaultValue = "-1.0") length: Double
    ): String? {
        return fishService?.updateFish(id,length,weight,apiKey)
    }


    @DeleteMapping("/delete")
    fun deleteFish(
        @RequestHeader("api-key", required = true) apiKey: String,
        @RequestParam("id", required = true,) id:Long
    ):String{
        return fishService!!.deleteFish(id,apiKey)
    }

}