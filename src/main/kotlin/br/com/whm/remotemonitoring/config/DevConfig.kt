package br.com.whm.remotemonitoring.config

import br.com.whm.remotemonitoring.model.entity.Device
import br.com.whm.remotemonitoring.model.entity.User
import br.com.whm.remotemonitoring.model.entity.UserSettings
import br.com.whm.remotemonitoring.model.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("dev")
class DevConfig (@Autowired val userRepository: UserRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {

        val user1 = User(null, "higoroliveiiira@gmail.com", "teste123",  "Higor",
                "9999999999")
        val userSet = UserSettings(2, 10.0, 10.0,10.0, user1)

        val device = Device(null, "kjsadhaksljdhaksjlhdkajslhdjkashdjlkasdhjkalsdhjaks", user1)
        user1.settings = userSet
        user1.device = device
        userRepository.save(user1)
    }

}