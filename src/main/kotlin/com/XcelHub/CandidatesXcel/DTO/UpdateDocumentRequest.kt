package com.XcelHub.CandidatesXcel.DTO

data class UpdateDocumentRequest(
    val id: Long,
    val title: String?,
    val type: String?,
    val filePath: String?
)
