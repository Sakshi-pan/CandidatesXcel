package com.XcelHub.CandidatesXcel.Entity
import jakarta.persistence.*

@Entity
@Table(name = "address")
class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "house_no")
    var houseNo: String? = null,

    @Column(name = "street_no")
    var streetNo: String? = null,

    @Column(name = "city")
    var city: String? = null,

    @Column(name = "state")
    var state: String? = null,

    @Column(name = "pincode")
    var pincode: String? = null,

    @Column(name = "country")
    var country: String? = null
) {
    constructor(
        houseNo: String?,
        streetNo: String?,
        city: String?,
        state: String?,
        pincode: String?,
        country: String?
    ) : this() {
        this.houseNo = houseNo
        this.streetNo = streetNo
        this.city = city
        this.state = state
        this.pincode = pincode
        this.country = country
    }

    override fun toString(): String {
        return "Address{" +
                "id=" + id +
                ", houseNo='" + houseNo + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode='" + pincode + '\'' +
                ", country='" + country + '\'' +
                '}'
    }
}
