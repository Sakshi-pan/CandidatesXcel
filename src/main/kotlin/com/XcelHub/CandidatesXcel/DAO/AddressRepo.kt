package com.XcelHub.CandidatesXcel.DAO

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.XcelHub.CandidatesXcel.Entity.Address
@Repository
interface AddressRepo : JpaRepository<Address, Long>{

}
