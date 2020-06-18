package br.com.whm.remotemonitoring.model.service.exception

class ResourceAlreadyExists(message: String): Exception("Resource already exists: $message") {
    companion object {
        private const val serialVersionUID = 1L
    }
}
