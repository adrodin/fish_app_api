package fish.app.controllers

import fish.app.models.User
import fish.app.repositories.FishRepository
import fish.app.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("fish")
class FishController {


    @Autowired
    private val repo: FishRepository? = null
    @Autowired
    private val userRepo: UserRepository? = null

    @GetMapping("/showAll")
    fun findCities(): String? {
       return repo?.findAll().toString()
    }

    @GetMapping("/name/{name}")
    fun findByName(@PathVariable name: String): String?{
        val us = userRepo?.findByName(name)
        val names = repo?.findByUser(us!!)
        return names.toString()
    }


//    @GetMapping("/name/{name}")
//    fun findByName(@PathVariable name: String): String?{
//        val names = repo?.findByName(name)
//        return names.toString()
//    }



}