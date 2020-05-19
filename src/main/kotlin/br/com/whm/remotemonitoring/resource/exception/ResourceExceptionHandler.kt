package br.com.whm.remotemonitoring.resource.exception

import br.com.whm.remotemonitoring.model.DTO.StandardError
import br.com.whm.remotemonitoring.model.service.exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.time.Instant
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFound(ex: ResourceNotFoundException, request: HttpServletRequest): ResponseEntity<StandardError> {
        val statusCode = HttpStatus.NOT_FOUND
        val error = StandardError(ex.message!!, request.requestURI, Instant.now())

        return ResponseEntity.status(statusCode).body(error)
    }
}