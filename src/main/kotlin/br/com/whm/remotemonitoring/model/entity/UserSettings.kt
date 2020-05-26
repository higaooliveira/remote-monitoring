package br.com.whm.remotemonitoring.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.validation.annotation.Validated
import javax.persistence.*

@Validated
@Entity
@Table(name = "users_settings")
data class UserSettings(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,

        @Column(name = "heart_rate_avg")
        @JsonProperty("heart_rate_avg")
        val heartRateAverage: Double,

        @Column(name = "oximetry_avg")
        @JsonProperty("oximetry_avg")
        val oximetryAverage: Double,

        @Column(name = "temperature_avg")
        @JsonProperty("temperature_avg")
        val temperatureAverage: Double,

        @JsonIgnore
        @OneToOne
        @MapsId
        val user: User
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserSettings

        if (id != other.id) return false
        if (user != other.user) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + user.hashCode()
        return result
    }
}