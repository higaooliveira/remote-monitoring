package br.com.whm.remotemonitoring.model.repository

import br.com.whm.remotemonitoring.model.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>