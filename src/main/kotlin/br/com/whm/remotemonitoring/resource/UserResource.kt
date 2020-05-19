package br.com.whm.remotemonitoring.resource

import br.com.whm.remotemonitoring.model.entity.User
import br.com.whm.remotemonitoring.model.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api"])
class UserResource(@Autowired val service: UserService){

    @GetMapping(value = ["/user/{id}"])
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user: User = service.findById(id)

        return ResponseEntity.ok(user)
    }
}