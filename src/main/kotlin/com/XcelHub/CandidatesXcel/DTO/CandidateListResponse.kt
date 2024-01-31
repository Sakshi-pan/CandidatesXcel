package com.XcelHub.CandidatesXcel.DTO
import com.XcelHub.CandidatesXcel.Entity.Candidate
import com.XcelHub.CandidatesXcel.Entity.DepartmentEnum
import com.XcelHub.CandidatesXcel.Entity.EmploymentEnum
class CandidateListResponse(candidate: Candidate) {
    var name: String = "${candidate.firstName} ${candidate.lastName}"
    var emailId: String = candidate.emailId.toString()
    var department: DepartmentEnum? = candidate.department
    var competency: String? = candidate.competency
    var designation: String? = candidate.designation
    var employmentType: EmploymentEnum? = candidate.employmentType
}
