package com.XcelHub.CandidatesXcel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import com.XcelHub.CandidatesXcel.DAO.*
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import com.XcelHub.CandidatesXcel.Entity.*
import java.time.LocalDate

@SpringBootApplication
class CandidatesXcelApplication

fun main(args: Array<String>) {
	runApplication<CandidatesXcelApplication>(*args)
}

@Component
class DataInitializer(private val candidateRepository: CandidateRepo,
					  private val addressRepository: AddressRepo,
					  private val educationDetailsRepository: EducationDetailsRepo,
					  private val workExperienceRepository: WorkExperienceRepo) {

	@Bean
	fun initializeData(): CommandLineRunner {
		return CommandLineRunner {
			// Create Address
			val address = Address("25", "E-2", "New Delhi", "Delhi", "110094", "India")
			addressRepository.save(address)
			val address1 = Address("24", "E-2", "Lucknow", "UP", "110094", "India")
			addressRepository.save(address1)

			// Create EducationDetails
			val educationDetails = EducationDetails(2018, 85.4,
				"Joseph & Mary Public School", 2020, 88.6, "Jospeh and Mary Public School",
				"Galgotias University", "B.Tech", 2024, 90.2,
				"XYZ University", "M.Tech", 2018, 85.0)
			educationDetailsRepository.save(educationDetails)
			val educationDetails1 = EducationDetails(2020, 85.4,
				"Joseph & Mary Public School", 2022, 88.6, "Jospeh and Mary Public School",
				"Galgotias University", "B.Tech", 2026, 90.2,
				"XYZ University", "M.Tech", 2028, 85.0)
			educationDetailsRepository.save(educationDetails1)

			// Create WorkExperience
			val workExperience = WorkExperience("ABC Company", "Software Engineer Trainee",
				LocalDate.of(2021, 6, 1), LocalDate.of(2022, 5, 30), "Worked as a software engineer")
			workExperienceRepository.save(workExperience)
			val workExperience1 = WorkExperience("XYZ Company", "Software Engineer Trainee",
				LocalDate.of(2023, 6, 1), LocalDate.of(2024, 5, 30), "Worked as a software engineer")
			workExperienceRepository.save(workExperience1)

			// Create Candidate
			val candidate = Candidate(1, "Sakshi", "Pandey", "Female",
				LocalDate.of(2003, 2, 21), "sakshipandey21022003@gmail.com", "9821955176",
				DepartmentEnum.Technology, "Software Engineer Trainee", EmploymentEnum.INTERNSHIP,
				"Java, Spring Boot", educationDetails, address, workExperience)

			candidateRepository.save(candidate)
			val candidate1 = Candidate(2, "Vivek", "Agarhari", "Male",
				LocalDate.of(2003, 2, 21), "vivek@gmail.com", "9821955178",
				DepartmentEnum.FINANCE, "Trainee", EmploymentEnum.FULL_TIME,
				"Java, Spring Boot", educationDetails, address, workExperience)

			candidateRepository.save(candidate1)
		}
	}
}
