package br.com.whm.remotemonitoring.util

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

object PasswordEncoder {

    fun encrypt(password: String): String = BCryptPasswordEncoder().encode(password)
}