package br.com.whm.remotemonitoring.model.entity.pk

import br.com.whm.remotemonitoring.model.entity.Monitor
import br.com.whm.remotemonitoring.model.entity.User
import java.io.Serializable
import javax.persistence.Embeddable
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Embeddable
class UserHasMonitorPk: Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id")
    lateinit var user: User

    @ManyToOne
    @JoinColumn(name = "product_id")
    lateinit var monitor: Monitor


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserHasMonitorPk) return false

        if (user != other.user) return false
        if (monitor != other.monitor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = user.hashCode()
        result = 31 * result + monitor.hashCode()
        return result
    }


}