package br.com.whm.remotemonitoring.model.service.exception

class ResourceAlreadyExists(email: String): Exception("Resource already exists with that email: $email") {
    companion object {
        private const val serialVersionUID = 1L
    }
}
