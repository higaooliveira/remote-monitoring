package br.com.whm.remotemonitoring.model.DTO

import br.com.whm.remotemonitoring.model.entity.User
import br.com.whm.remotemonitoring.model.entity.UserSettings
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class SettingsDTO (

        @NotBlank(message = "Heart rate must be informed")
        @NotEmpty(message = "Heart rate must be informed")
        @NotNull(message = "Heart rate must be informed")
        @JsonProperty("heart_rate_avg")
        val heartRateAverage: Double,

        @NotBlank(message = "Oximetry must be informed")
        @NotEmpty(message = "Oximetry must be informed")
        @NotNull(message = "Oximetry must be informed")
        @JsonProperty("oximetry_avg")
        val oximetryAverage: Double,

        @NotBlank(message = "Temperature must be informed")
        @NotEmpty(message = "Temperature must be informed")
        @NotNull(message = "Temperature must be informed")
        @JsonProperty("temperature_avg")
        val temperatureAverage: Double
){
    fun toEntity(user: User): UserSettings = UserSettings(
            null,
            heartRateAverage,
            oximetryAverage,
            temperatureAverage,
            user
    )
}