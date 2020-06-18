package br.com.whm.remotemonitoring.resource

import br.com.whm.remotemonitoring.model.DTO.SettingsDTO
import br.com.whm.remotemonitoring.model.DTO.UserRegisterDTO
import br.com.whm.remotemonitoring.model.entity.User
import br.com.whm.remotemonitoring.model.service.UserService
import br.com.whm.remotemonitoring.util.HateoasHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/api"])
class UserResource(@Autowired val service: UserService){

    @GetMapping(value = ["/users/{id}"])
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user: User = service.findById(id)

        return ResponseEntity.ok(user)
    }

    @PostMapping(value = ["/users"])
    fun create(@Valid @RequestBody user: UserRegisterDTO): ResponseEntity<User>{
        val newUser = this.service.create(user)

        return ResponseEntity.created(HateoasHelper.buildUrlToGetRequest(newUser.id!!)).body(newUser)

    }

    @PostMapping(value = ["/users/{id}/settings"])
    fun createSettings(@PathVariable id: Long, @Valid @RequestBody settings: SettingsDTO): ResponseEntity<User>{
        val user = this.service.createSettings(id, settings)

        return ResponseEntity.created(HateoasHelper.buildUrlToGetRequest(user.id!!)).body(user)
    }
}