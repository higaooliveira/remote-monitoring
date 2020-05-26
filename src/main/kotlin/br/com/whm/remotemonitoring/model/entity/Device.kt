package br.com.whm.remotemonitoring.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.validation.annotation.Validated
import javax.persistence.*

@Validated
@Entity
@Table(name = "device")
data class Device (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,

        @Column(name = "hardware_id")
        @JsonProperty("hardware_id")
        val hardwareId: String,

        @JsonIgnore
        @OneToOne
        @MapsId
        val user: User
) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other !is Device) return false

                if (hardwareId != other.hardwareId) return false
                if (user != other.user) return false

                return true
        }

        override fun hashCode(): Int {
                var result = hardwareId.hashCode()
                result = 31 * result + user.hashCode()
                return result
        }
}