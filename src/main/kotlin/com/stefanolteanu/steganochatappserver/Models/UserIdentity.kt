package com.stefanolteanu.steganochatappserver.Models

import com.google.gson.annotations.SerializedName
import java.io.Serial
import javax.persistence.*

@Entity
@Table(name = "users")
class UserIdentity {

    constructor()

    constructor(phoneNumber: String, deviceId: String) {
        this.phoneNumber = phoneNumber
        this.deviceId = deviceId
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id",updatable = false, nullable = false)
    var id: Int = 0

    @Column(name="phone_number")
    lateinit var phoneNumber : String

    @Column(name="device_id")
    lateinit var deviceId : String
}