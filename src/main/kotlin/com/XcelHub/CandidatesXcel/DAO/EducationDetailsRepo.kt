package com.XcelHub.CandidatesXcel.DAO

import org.springframework.data.jpa.repository.JpaRepository
import com.XcelHub.CandidatesXcel.Entity.EducationDetails
import org.springframework.stereotype.Repository

@Repository
interface EducationDetailsRepo : JpaRepository<EducationDetails, Long> {
}