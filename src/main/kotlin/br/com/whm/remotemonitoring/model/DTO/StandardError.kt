package br.com.whm.remotemonitoring.model.DTO

import java.time.Instant

data class StandardError(val message: String, val path: String, val date: Instant)