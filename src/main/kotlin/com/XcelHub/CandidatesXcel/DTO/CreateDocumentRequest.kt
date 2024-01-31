package com.XcelHub.CandidatesXcel.DTO

data class CreateDocumentRequest(
    val title: String,
    val type: String,
    val content: ByteArray
)
