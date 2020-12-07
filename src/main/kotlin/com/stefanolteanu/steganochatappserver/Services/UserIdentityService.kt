package com.stefanolteanu.steganochatappserver.Services

import com.stefanolteanu.steganochatappserver.Models.UserIdentity

public interface UserIdentityService {

    fun getUserIdentityByPhoneNumber(phoneNumber : String) : UserIdentity

    fun insertUserIdentity(userIdentity: UserIdentity) : UserIdentity

    fun updateDeviceForPhoneNumber(userIdentity: UserIdentity) : UserIdentity

}