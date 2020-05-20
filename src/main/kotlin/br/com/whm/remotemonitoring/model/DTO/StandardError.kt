package br.com.whm.remotemonitoring.model.DTO

import java.time.Instant

data class StandardError(val messages: HashSet<String>, val path: String, val date: Instant)