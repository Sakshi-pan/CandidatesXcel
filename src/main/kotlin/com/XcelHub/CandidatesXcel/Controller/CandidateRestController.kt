import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import com.XcelHub.CandidatesXcel.DTO.*
import com.XcelHub.CandidatesXcel.DAO.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import com.XcelHub.CandidatesXcel.Entity.*
@RestController
@RequestMapping("/xcelhub/api/v1/candidate")
class CandidateRestController(
    private val candidateRepo: CandidateRepo,
    private val documentRepo: DocumentRepo
) {

    @GetMapping
    fun getAllCandidatesByHR(): ResponseEntity<List<CandidateListResponse>> {
        val candidates = candidateRepo.findAll()
        return if (candidates.isEmpty()) {
            ResponseEntity.notFound().build()
        } else {
            val candidateDTOs = candidates.map { CandidateListResponse(it) }
            ResponseEntity.ok(candidateDTOs)
        }
    }

    @GetMapping("/forhr/{id}")
    fun getCandidateDetailsByHR(@PathVariable id: String): ResponseEntity<CandidateDetailsResponse> {
        val candidate = candidateRepo.findById(id).orElse(null)
        return if (candidate == null) {
            ResponseEntity.notFound().build()
        } else {
            val candidateDetailsDTO = CandidateDetailsResponse(candidate)
            ResponseEntity.ok(candidateDetailsDTO)
        }
    }

    @PostMapping("/documents/upload")
    fun uploadDocument(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        return try {
            if (file.isEmpty) {
                ResponseEntity("Please select a file to upload", HttpStatus.BAD_REQUEST)
            } else {
                // Process file content and save document
                val savedDocument = documentRepo.save(processDocument(file))
                ResponseEntity.ok("File uploaded successfully. ID: ${savedDocument.id}")
            }
        } catch (e: Exception) {
            ResponseEntity("Failed to upload file: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    private fun processDocument(file: MultipartFile): Document {
        val fileContent = file.bytes
        return Document(
            title = file.originalFilename,
            type = file.contentType,
            content = fileContent
        )
    }

    @PostMapping("/documents")
    fun submitDocument(@RequestBody request: DocumentRequest): ResponseEntity<String> {
        return try {
            val document = convertDocumentRequestToDocument(request)
            val savedDocument = documentRepo.save(document)
            ResponseEntity.ok("Document submitted successfully. ID: ${savedDocument.id}")
        } catch (e: Exception) {
            ResponseEntity("Failed to submit document: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    // Helper function to convert DocumentRequest to Document object
    private fun convertDocumentRequestToDocument(request: DocumentRequest): Document {
        return Document(title = request.title, type = request.type, content = request.content)
    }


    @PutMapping("/documents/{id}")
    fun updateDocument(
        @PathVariable id: Long,
        @RequestParam("file") file: MultipartFile?,
        @RequestBody request: UpdateDocumentRequest
    ): ResponseEntity<String> {
        return try {
            val existingDocument = documentRepo.findById(id).orElse(null)
            if (existingDocument == null) {
                ResponseEntity.notFound().build()
            } else {
                existingDocument.title = request.title
                existingDocument.type = request.type

                // Assuming filePath is not updated via the request
                // If filePath needs to be updated, ensure it's included in the UpdateDocumentRequest
                // existingDocument.filePath = request.filePath

                file?.let {
                    if (!it.isEmpty) {
                        existingDocument.content = it.bytes
                        existingDocument.title = it.originalFilename
                        existingDocument.type = it.contentType
                    }
                }
                val updatedDocument = documentRepo.save(existingDocument)
                ResponseEntity.ok("Document updated successfully. ID: $id")
            }
        } catch (e: Exception) {
            ResponseEntity("Failed to update document: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @DeleteMapping("/documents/{id}")
    fun deleteDocument(@PathVariable id: Long): ResponseEntity<String> {
        return try {
            documentRepo.deleteById(id)
            ResponseEntity.ok("Document deleted successfully. ID: $id")
        } catch (e: Exception) {
            ResponseEntity("Failed to delete document: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


}
