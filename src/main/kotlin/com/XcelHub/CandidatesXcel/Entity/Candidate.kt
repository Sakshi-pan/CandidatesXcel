package com.XcelHub.CandidatesXcel.Entity
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
@Entity
@Table(name = "candidate")
class Candidate(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    var id: String? = null,

    @Column(name = "candidate_id")
    var candidateId: Int = 0,

    @Column(name = "first_name")
    var firstName: String? = null,

    @Column(name = "last_name")
    var lastName: String? = null,

    @Column(name = "gender")
    var gender: String? = null,

    @Column(name = "dob")
    var dob: LocalDate? = null,

    @Column(name = "emailId")
    var emailId: String? = null,

    @Column(name = "contact_no")
    var contactNo: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "department")
    var department: DepartmentEnum? = null,

    @Column(name = "designation")
    var designation: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "employment_type")
    var employmentType: EmploymentEnum? = null,

    @Column(name = "competency")
    var competency: String? = null,

    @ManyToOne
    @JoinColumn(name = "education_details_id")
    var educationDetails: EducationDetails? = null,

    @ManyToOne
    @JoinColumn(name = "address_id")
    var address: Address? = null,

    @ManyToOne
    @JoinColumn(name = "work_experience_id")
    var workExperience: WorkExperience? = null
) {
    constructor(
        candidateId: Int,
        firstName: String?,
        lastName: String?,
        gender: String?,
        dob: LocalDate?,
        emailId: String?,
        contactNo: String?,
        department: DepartmentEnum?,
        designation: String?,
        employmentType: EmploymentEnum?,
        competency: String?,
        educationDetails: EducationDetails?,
        address: Address?,
        workExperience: WorkExperience?
    ) : this(
        null,
        candidateId,
        firstName,
        lastName,
        gender,
        dob,
        emailId,
        contactNo,
        department,
        designation,
        employmentType,
        competency,
        educationDetails,
        address,
        workExperience
    )
}