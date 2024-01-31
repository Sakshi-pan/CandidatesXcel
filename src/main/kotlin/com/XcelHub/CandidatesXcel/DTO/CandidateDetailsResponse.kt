package com.XcelHub.CandidatesXcel.DTO
import com.XcelHub.CandidatesXcel.Entity.*
import com.XcelHub.CandidatesXcel.Entity.DepartmentEnum
import com.XcelHub.CandidatesXcel.Entity.EmploymentEnum
class CandidateDetailsResponse(candidate: Candidate) {
    var name: String = "${candidate.firstName} ${candidate.lastName}"
    var emailId: String = candidate.emailId.toString()
    var contactNo: String? = candidate.contactNo
    var gender: String? = candidate.gender
    var dob: String = candidate.dob.toString()

    var department: DepartmentEnum? = candidate.department
    var competency: String? = candidate.competency
    var designation: String? = candidate.designation
    var employmentType: EmploymentEnum? = candidate.employmentType

    var educationDetails: EducationDetails? = candidate.educationDetails
    var workExperience: WorkExperience? = candidate.workExperience
}