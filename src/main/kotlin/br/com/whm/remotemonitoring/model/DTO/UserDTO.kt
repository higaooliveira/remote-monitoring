package br.com.whm.remotemonitoring.model.DTO

import br.com.whm.remotemonitoring.model.entity.Device
import br.com.whm.remotemonitoring.model.entity.User
import br.com.whm.remotemonitoring.model.entity.UserSettings
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class UserRegisterDTO (
        @NotBlank(message = "User must be an email")
        @NotEmpty(message = "User must be an email")
        @Email(message = "You must be send a valid email")
        val email: String,

        @NotBlank
        val password: String,

        @get:NotNull(message = "User must be contain name")
        @NotBlank(message = "User must be contain name")
        @NotEmpty(message = "User must be contain name")
        val name: String,

        @NotBlank(message = "User must be contain phone")
        @NotEmpty(message = "User must be contain phone")
        val phone: String,

        @get:NotNull(message = "User must be contain settings")
        @NotBlank(message = "User must be contain settings")
        @NotEmpty(message = "User must be contain settings")
        val heartRateAvg: Double,
        
        @get:NotNull(message = "User must be contain settings")
        @NotBlank(message = "User must be contain settings")
        @NotEmpty(message = "User must be contain settings")
        val oximetryAvg: Double,

        @get:NotNull(message = "User must be contain settings")
        @NotBlank(message = "User must be contain settings")
        @NotEmpty(message = "User must be contain settings")
        val temperatureAvg: Double,

        @get:NotNull(message = "User must be contain settings")
        @NotBlank(message = "User must be contain settings")
        @NotEmpty(message = "User must be contain settings")
        val hardwareId: String
){
    fun toEntity(): User {
            val user = User(
                    id = null,
                    email = email,
                    password = password,
                    name = name,
                    phone = phone
            )
            user.settings = userSettingsFactory(user)
            user.device = deviceFactory(user)
            return user
    }
        private fun userSettingsFactory(user: User): UserSettings = UserSettings(
                id = null,
                heartRateAverage = heartRateAvg,
                oximetryAverage = oximetryAvg,
                temperatureAverage = temperatureAvg,
                user = user
        )

        private fun deviceFactory(user: User): Device = Device(null, hardwareId, user)
}