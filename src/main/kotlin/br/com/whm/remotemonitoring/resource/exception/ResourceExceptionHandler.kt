package br.com.whm.remotemonitoring.resource.exception

import br.com.whm.remotemonitoring.model.DTO.StandardError
import br.com.whm.remotemonitoring.model.service.exception.ResourceAlreadyExists
import br.com.whm.remotemonitoring.model.service.exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.time.Instant
import javax.servlet.http.HttpServletRequest
import javax.validation.ConstraintViolation
import javax.validation.ConstraintViolationException

@ControllerAdvice
class ResourceExceptionHandler {

    val messageList: HashSet<String> = HashSet()
    lateinit var statusCode: HttpStatus
    lateinit var error: StandardError

    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFound(ex: ResourceNotFoundException, request: HttpServletRequest): ResponseEntity<StandardError> {
        this.statusCode = HttpStatus.NOT_FOUND
        this.messageList.add(ex.message!!)
        this.error = StandardError(this.messageList, request.requestURI, Instant.now())

        return ResponseEntity.status(statusCode).body(error)
    }

    @ExceptionHandler(ResourceAlreadyExists::class)
    fun resourceAlreadyExists(ex: ResourceAlreadyExists, request: HttpServletRequest): ResponseEntity<StandardError> {
        this.statusCode = HttpStatus.CONFLICT
        this.messageList.add(ex.message!!)
        this.error = StandardError(this.messageList, request.requestURI, Instant.now())

        return ResponseEntity.status(this.statusCode).body(this.error)
    }

    @ExceptionHandler(value = [ConstraintViolationException::class, HttpMessageNotReadableException::class])
    fun badRequestHandle(ex: Exception, request: HttpServletRequest): ResponseEntity<StandardError> {
        this.statusCode = HttpStatus.CONFLICT

        when(ex){
            is ConstraintViolationException ->  ex.constraintViolations.forEach {
                this.messageList += it.message
            }
            is HttpMessageNotReadableException -> this.messageList += ex.message!!
                    .split(";")[0]
                    .split(",")
                    .last()
                    .trim()
                    .capitalize() + " must be informed"
        }

        this.error = StandardError(this.messageList, request.requestURI, Instant.now())
        return ResponseEntity.status(this.statusCode).body(this.error)
    }
}