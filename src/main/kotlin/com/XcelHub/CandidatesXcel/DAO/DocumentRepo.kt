package com.XcelHub.CandidatesXcel.DAO

import org.springframework.data.jpa.repository.JpaRepository
import com.XcelHub.CandidatesXcel.Entity.*
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface DocumentRepo :JpaRepository<Document, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Document d SET d.title = :title, d.type = :type WHERE d.id = :id")
    fun update(@Param("id") id: Long, @Param("title") title: String, @Param("type") type: String): Int

}
