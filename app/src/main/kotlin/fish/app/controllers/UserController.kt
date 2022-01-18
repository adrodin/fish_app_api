package fish.app.controllers

import fish.app.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("user")
class UserController {

    @Autowired
    private val userService: UserService? =null

    @PostMapping("/registry")
    fun registry(@RequestParam(value="name",required = true) name: String,
                 @RequestParam(value="email",required = true) email: String,
                 @RequestParam(value="password",required = true) password: String
    ): String? {
        return userService?.registry(name=name,email=email,password=password)
    }

    @GetMapping("/key")
    fun getApiKey(@RequestParam("name", required = true) name: String,
                  @RequestParam("password", required = true) password: String
    ): String{
        if (userService != null) {
            return userService.getApiKey(name,password)
        }
        return "Error"
    }

    @PutMapping("/update")
    fun updateUser(
        @RequestHeader("api-key", required = true) key: String,
        @RequestParam(value="email", defaultValue = "-1") email: String,
        @RequestParam(value="password", defaultValue = "-1") password: String
    ):String{
        return userService?.updateUser(email,password,key).toString()
    }

}