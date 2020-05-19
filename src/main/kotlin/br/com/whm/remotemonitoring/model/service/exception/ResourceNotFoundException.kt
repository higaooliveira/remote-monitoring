package br.com.whm.remotemonitoring.model.service.exception

class ResourceNotFoundException(id: Long): Exception("Resource not found, id: $id") {
    companion object {
        private const val serialVersionUID = 1L
    }
}