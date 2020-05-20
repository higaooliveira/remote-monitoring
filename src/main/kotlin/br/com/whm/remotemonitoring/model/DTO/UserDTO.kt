package br.com.whm.remotemonitoring.model.DTO

import br.com.whm.remotemonitoring.model.entity.User
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
        val phone: String
){
    fun toEntity(): User = User(email=email, password = password, name = name, phone = phone)
}