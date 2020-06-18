package br.com.whm.remotemonitoring.model.entity

import br.com.whm.remotemonitoring.model.entity.pk.UserHasMonitorPk
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "user_has_monitor")
class UserHasMonitor(user: User, monitor: Monitor) {

    @EmbeddedId
    private val id = UserHasMonitorPk()
    lateinit var token: String

    init {
        this.id.user = user
        this.id.monitor = monitor
    }

    fun getUser(): User = this.id.user
    fun setUser(user: User) {
        this.id.user = user
    }

    fun getMonitor(): Monitor = this.id.monitor
    fun setMonitor(monitor: Monitor){
        this.id.monitor = monitor
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserHasMonitor) return false

        if (id != other.id) return false
        if (token != other.token) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + token.hashCode()
        return result
    }
}
