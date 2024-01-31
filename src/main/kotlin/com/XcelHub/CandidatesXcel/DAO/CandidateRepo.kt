package com.XcelHub.CandidatesXcel.DAO

import com.XcelHub.CandidatesXcel.Entity.Candidate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CandidateRepo : JpaRepository<Candidate, String> {
}