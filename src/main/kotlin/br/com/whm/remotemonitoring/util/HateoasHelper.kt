package br.com.whm.remotemonitoring.util

import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

object HateoasHelper {

    fun buildUrlToGetRequest(id: Long): URI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(id)
            .toUri()
}