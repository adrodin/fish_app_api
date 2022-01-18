package fish.app.controllers

import fish.app.services.RankService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.sql.Date


@RestController
class RankController {

    @Autowired
    private val rankService: RankService? = null

    @GetMapping("/rank")
    fun rank(
        @RequestParam("species",defaultValue = "all")species:String,
        @RequestParam("date-start",defaultValue = "1960-01-01")dateStart:Date,
        @RequestParam("date-end",defaultValue = "2100-01-01")dateEnd:Date,
        @RequestParam("limit",defaultValue = "20")number:Int,
        @RequestParam("order",defaultValue = "weight")orderBy:String
    ): String? {
        return rankService?.rank(species,dateStart,dateEnd,orderBy,number)
    }
}