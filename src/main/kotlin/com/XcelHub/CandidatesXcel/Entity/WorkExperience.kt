package com.XcelHub.CandidatesXcel.Entity

import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "work_experience")
class WorkExperience(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "company")
    var company: String? = null,

    @Column(name = "position")
    var position: String? = null,

    @Column(name = "start_date")
    var startDate: LocalDate? = null,

    @Column(name = "end_date")
    var endDate: LocalDate? = null,

    @Column(name = "description")
    var description: String? = null
) {
    constructor(
        company: String?,
        position: String?,
        startDate: LocalDate?,
        endDate: LocalDate?,
        description: String?
    ) : this() {
        this.company = company
        this.position = position
        this.startDate = startDate
        this.endDate = endDate
        this.description = description
    }

    override fun toString(): String {
        return "WorkExperience{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}'
    }
}