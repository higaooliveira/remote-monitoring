package br.com.whm.remotemonitoring.model.service

import br.com.whm.remotemonitoring.model.DTO.UserRegisterDTO
import br.com.whm.remotemonitoring.model.entity.User
import br.com.whm.remotemonitoring.model.repository.UserRepository
import br.com.whm.remotemonitoring.model.service.exception.ResourceAlreadyExists
import br.com.whm.remotemonitoring.model.service.exception.ResourceNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.*

@Component
@Service
class UserService(@Autowired val userRepository: UserRepository){

    fun findById(id: Long): User {
        val user: Optional<User> = this.userRepository.findById(id)

        return user.orElseThrow { ResourceNotFoundException(id) }
    }

    fun create(user: UserRegisterDTO): User {
        if (emailExists(user.email)){
            throw ResourceAlreadyExists(user.email)
        }

        val newUser = user.toEntity()
        newUser.encryptPassword()
        return this.userRepository.save(newUser)
    }

    private fun emailExists(email: String): Boolean = userRepository.findByEmail(email) != null
}
