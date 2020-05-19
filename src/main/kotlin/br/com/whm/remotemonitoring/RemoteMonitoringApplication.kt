package br.com.whm.remotemonitoring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RemoteMonitoringApplication

fun main(args: Array<String>) {
	runApplication<RemoteMonitoringApplication>(*args)
}
