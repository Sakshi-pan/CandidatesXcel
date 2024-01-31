package com.XcelHub.CandidatesXcel.DAO

import com.XcelHub.CandidatesXcel.Entity.WorkExperience
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkExperienceRepo : JpaRepository<WorkExperience ,Long> {
}