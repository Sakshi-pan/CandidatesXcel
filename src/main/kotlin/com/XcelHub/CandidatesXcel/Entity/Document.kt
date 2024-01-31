package com.XcelHub.CandidatesXcel.Entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "documents")
class Document(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "title")
    var title: String? = null,

    @Column(name = "type", columnDefinition = "TEXT")
    var type: String? = null,

    @Column(name = "file_path")
    var filePath: String? = null,

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()
) {
    constructor(
        title: String?,
        type: String?,
        filePath: String?,
        createdAt: LocalDateTime = LocalDateTime.now()
    ) : this(null, title, type, filePath, createdAt)
}