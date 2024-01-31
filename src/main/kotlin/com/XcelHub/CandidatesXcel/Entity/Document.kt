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

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "content", nullable = false)
    var content: ByteArray? = null,

    @Column(name = "created_at")
    var createdAt: LocalDateTime = LocalDateTime.now()
) {
    constructor(
        title: String?,
        type: String?,
        content: ByteArray?,
        createdAt: LocalDateTime = LocalDateTime.now()
    ) : this(null, title, type, content, createdAt)
}
