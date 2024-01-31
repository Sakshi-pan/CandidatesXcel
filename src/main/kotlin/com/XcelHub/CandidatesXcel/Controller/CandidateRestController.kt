package com.XcelHub.CandidatesXcel.Controller
import com.XcelHub.CandidatesXcel.Entity.*
import com.XcelHub.CandidatesXcel.DAO.CandidateRepo
import com.XcelHub.CandidatesXcel.DAO.DocumentRepo
import com.XcelHub.CandidatesXcel.DTO.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/xcelhub/api/v1/candidate")
class CandidateRestController(
    private val candidateRepo: CandidateRepo,
    private val documentRepo: DocumentRepo
) {

    @GetMapping
    fun getAllCandidatesByHR(): ResponseEntity<List<CandidateListResponse>> {
        val candidates = candidateRepo.findAll()
        if (candidates.isEmpty()) {
            return ResponseEntity.notFound().build()
        }
        val candidateDTOs = candidates.map { CandidateListResponse(it) }
        return ResponseEntity.ok(candidateDTOs)
    }

    @GetMapping("/forhr/{id}")
    fun getCandidateDetailsByHR(@PathVariable id: String): ResponseEntity<CandidateDetailsResponse> {
        val candidate = candidateRepo.findById(id).orElse(null)
        if (candidate == null) {
            return ResponseEntity.notFound().build()
        }
        val candidateDetailsDTO = CandidateDetailsResponse(candidate)
        return ResponseEntity.ok(candidateDetailsDTO)
    }

    @PostMapping("/documents/upload")
    fun uploadDocument(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        if (file.isEmpty) {
            return ResponseEntity("Please select a file to upload", HttpStatus.BAD_REQUEST)
        }

        try {
            // Process the file data and save it using documentRepo
            val savedDocument = documentRepo.save(convertMultipartFileToDocument(file))
            return ResponseEntity.ok("File uploaded successfully. ID: ${savedDocument.id}")
        } catch (e: Exception) {
            return ResponseEntity("Failed to upload file: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    // Helper function to convert MultipartFile to Document object
    fun convertMultipartFileToDocument(file: MultipartFile): Document {
        // Implement conversion logic here based on your Document entity structure
        // Example:
        return Document(title = file.originalFilename, type = file.contentType, filePath = "path/to/file")
    }
    @PostMapping("/documents")
    fun submitDocument(@RequestBody request: DocumentRequest): ResponseEntity<String> {
        try {
            val document = convertDocumentRequestToDocument(request)
            val savedDocument = documentRepo.save(document)
            return ResponseEntity.ok("Document submitted successfully. ID: ${savedDocument.id}")
        } catch (e: Exception) {
            return ResponseEntity("Failed to submit document: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    // Helper function to convert DocumentRequest to Document object
    fun convertDocumentRequestToDocument(request: DocumentRequest): Document {
        // Implement conversion logic here based on your Document entity structure
        // Example:
        return Document(title = request.title, type = request.type, filePath = request.filePath)
    }



    @PutMapping("/documents/{id}")
    fun updateDocument(
        @PathVariable id: Long,
        @RequestBody request: UpdateDocumentRequest
    ): ResponseEntity<String> {
        try {
            val existingDocument = documentRepo.findById(id).orElse(null)
            if (existingDocument == null) {
                return ResponseEntity.notFound().build()
            }

            // Update the existingDocument with the fields from the request
            existingDocument.title = request.title
            existingDocument.type= request.type
            existingDocument.filePath = request.filePath

            val updatedDocument = documentRepo.save(existingDocument)
            return ResponseEntity.ok("Document updated successfully. ID: $id")
        } catch (e: Exception) {
            return ResponseEntity("Failed to update document: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


    @DeleteMapping("/documents/{id}")
    fun deleteDocument(@PathVariable id: Long): ResponseEntity<String> {
        try {
            documentRepo.deleteById(id)
            return ResponseEntity.ok("Document deleted successfully. ID: $id")
        } catch (e: Exception) {
            return ResponseEntity("Failed to delete document: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}