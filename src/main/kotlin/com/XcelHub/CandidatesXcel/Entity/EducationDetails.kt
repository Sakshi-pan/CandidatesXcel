package com.XcelHub.CandidatesXcel.Entity

import jakarta.persistence.*


@Entity
@Table(name = "education_details")
class EducationDetails(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "highSchool_passingYear")
    var highSchoolPassingYear: Int = 0,

    @Column(name = "highSchool_percentage")
    var highSchoolPercentage: Double = 0.0,

    @Column(name = "highschool_name")
    var highschoolName: String? = null,

    @Column(name = "intermediate_passingYear")
    var intermediatePassingYear: Int = 0,

    @Column(name = "intermediate_percentage")
    var intermediatePercentage: Double = 0.0,

    @Column(name = "intermediate_schoolName")
    var intermediateSchoolName: String? = null,

    @Column(name = "graduation_College")
    var graduationCollege: String? = null,

    @Column(name = "graduation_courseName")
    var graduationCourseName: String? = null,

    @Column(name = "graduation_passoutYear")
    var graduationPassoutYear: Int = 0,

    @Column(name = "graduation_percentage")
    var graduationPercentage: Double = 0.0,

    @Column(name = "postGraduation_College")
    var postGraduationCollege: String? = null,

    @Column(name = "postGraduation_courseName")
    var postGraduationCourseName: String? = null,

    @Column(name = "postgraduation_passoutYear")
    var postGraduationPassoutYear: Int = 0,

    @Column(name = "postgraduation_percentage")
    var postGraduationPercentage: Double = 0.0
) {
    constructor(
        highSchoolPassingYear: Int,
        highSchoolPercentage: Double,
        highschoolName: String?,
        intermediatePassingYear: Int,
        intermediatePercentage: Double,
        intermediateSchoolName: String?,
        graduationCollege: String?,
        graduationCourseName: String?,
        graduationPassoutYear: Int,
        graduationPercentage: Double,
        postGraduationCollege: String?,
        postGraduationCourseName: String?,
        postGraduationPassoutYear: Int,
        postGraduationPercentage: Double
    ) : this() {
        this.highSchoolPassingYear = highSchoolPassingYear
        this.highSchoolPercentage = highSchoolPercentage
        this.highschoolName = highschoolName
        this.intermediatePassingYear = intermediatePassingYear
        this.intermediatePercentage = intermediatePercentage
        this.intermediateSchoolName = intermediateSchoolName
        this.graduationCollege = graduationCollege
        this.graduationCourseName = graduationCourseName
        this.graduationPassoutYear = graduationPassoutYear
        this.graduationPercentage = graduationPercentage
        this.postGraduationCollege = postGraduationCollege
        this.postGraduationCourseName = postGraduationCourseName
        this.postGraduationPassoutYear = postGraduationPassoutYear
        this.postGraduationPercentage = postGraduationPercentage
    }

    override fun toString(): String {
        return "EducationDetails{" +
                "id=" + id +
                ", highSchoolPassingYear=" + highSchoolPassingYear +
                ", highSchoolPercentage=" + highSchoolPercentage +
                ", highschoolName='" + highschoolName + '\'' +
                ", intermediatePassingYear=" + intermediatePassingYear +
                ", intermediatePercentage=" + intermediatePercentage +
                ", intermediateSchoolName='" + intermediateSchoolName + '\'' +
                ", graduationCollege='" + graduationCollege + '\'' +
                ", graduationCourseName='" + graduationCourseName + '\'' +
                ", graduationPassoutYear=" + graduationPassoutYear +
                ", graduationPercentage=" + graduationPercentage +
                ", postGraduationCollege='" + postGraduationCollege + '\'' +
                ", postGraduationCourseName='" + postGraduationCourseName + '\'' +
                ", postGraduationPassoutYear=" + postGraduationPassoutYear +
                ", postGraduationPercentage=" + postGraduationPercentage +
                '}'
    }
}