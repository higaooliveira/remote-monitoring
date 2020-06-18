package br.com.whm.remotemonitoring.model.entity

import org.springframework.validation.annotation.Validated
import javax.persistence.*

@Validated
@Entity
@Table(name = "monitors")
data class Monitor (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        val name: String,
        val email: String,
        val phone: String,

        @OneToMany(mappedBy = "id.user")
        val users: Set<UserHasMonitor> = HashSet()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Monitor) return false

        if (id != other.id) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + email.hashCode()
        return result
    }
}