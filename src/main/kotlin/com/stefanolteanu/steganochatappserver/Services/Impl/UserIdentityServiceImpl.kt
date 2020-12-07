package com.stefanolteanu.steganochatappserver.Services.Impl

import com.stefanolteanu.steganochatappserver.Models.UserIdentity
import com.stefanolteanu.steganochatappserver.Repositories.UserRepository
import com.stefanolteanu.steganochatappserver.Services.UserIdentityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Repository

@Repository
public class UserIdentityServiceImpl(@Autowired val userRepository: UserRepository) : UserIdentityService {

    override fun getUserIdentityByPhoneNumber(phoneNumber: String): UserIdentity {
        return try {
            userRepository.findUserIdentitiesByPhoneNumber(phoneNumber)
        } catch ( e : Exception) {
            throw EmptyResultDataAccessException(1)
        }
    }

    override fun insertUserIdentity(userIdentity: UserIdentity): UserIdentity {
        return userRepository.save(userIdentity)
    }

    override fun updateDeviceForPhoneNumber(userIdentity: UserIdentity): UserIdentity {
        val user = getUserIdentityByPhoneNumber(userIdentity.phoneNumber)
        user.deviceId = userIdentity.deviceId
        return userRepository.save(user)
    }

}