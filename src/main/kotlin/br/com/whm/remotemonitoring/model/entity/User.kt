package br.com.whm.remotemonitoring.model.entity

import br.com.whm.remotemonitoring.util.PasswordEncoder
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.validation.annotation.Validated
import javax.persistence.*

@Validated
@Entity
@Table(name = "users")
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        val email: String,

        @JsonIgnore
        var password: String,
        var name: String,
        var phone: String
) {
    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL])
    lateinit var settings: UserSettings

    @OneToOne(mappedBy = "user", cascade = [CascadeType.ALL])
    lateinit var device: Device

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }

    fun encryptPassword() {
        this.password = PasswordEncoder.encrypt(this.password)
    }
}