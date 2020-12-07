package com.stefanolteanu.steganochatappserver.Repositories

import com.stefanolteanu.steganochatappserver.Models.UserIdentity
import org.apache.catalina.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserIdentity, Int> {

    fun findUserIdentitiesByPhoneNumber(phoneNumber: String) : UserIdentity
}