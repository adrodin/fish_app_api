package fish.app.controllers

import fish.app.repositories.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable


@RestController
@RequestMapping("user")
class UserController {


    @Autowired
    private val repo:UserRepository? = null

    @GetMapping("/showUsers")
    fun findCities(): String? {
        var out = "{"
        for (user in repo!!.findAll()){
            out+=user.toString()+"\n"
        }
        out+="}"
        return out
    }

    @GetMapping("/name/{name}")
    fun findByName(@PathVariable name: String): String?{
        val names = repo?.findByName(name)
        return names.toString()
    }



}