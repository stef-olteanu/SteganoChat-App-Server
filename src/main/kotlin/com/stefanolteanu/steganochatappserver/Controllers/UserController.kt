package com.stefanolteanu.steganochatappserver.Controllers

import com.stefanolteanu.steganochatappserver.Exceptions.DatabaseDuplicateException
import com.stefanolteanu.steganochatappserver.Models.UserIdentity
import com.stefanolteanu.steganochatappserver.Services.UserIdentityService
import org.hibernate.dialect.Database
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import retrofit2.http.GET
import retrofit2.http.Headers
import java.sql.SQLException
import java.sql.SQLIntegrityConstraintViolationException

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired(required = true)
    private lateinit var userIdentityService: UserIdentityService

    @PostMapping("/enrollNewUser")
    public fun enrollUser(@RequestBody body: UserIdentity) : ResponseEntity<UserIdentity>? {
        try {
            val userIdentity = userIdentityService.insertUserIdentity(body)
            return if(userIdentity != null)
                ResponseEntity(userIdentity, HttpStatus.OK)
            else
                ResponseEntity(UserIdentity(), HttpStatus.OK)
        } catch ( e: Exception) {
            if(e is DataIntegrityViolationException)
                throw DatabaseDuplicateException(e.rootCause!!.message!!)
        }
        return null
    }

    @PostMapping("/updateDeviceForPhoneNumber")
    public fun updateDeviceForPhoneNumber(@RequestBody body: UserIdentity) : ResponseEntity<UserIdentity>? {
        try {
            val userIdentity = userIdentityService.updateDeviceForPhoneNumber(body)
            return if(userIdentity != null)
                ResponseEntity(userIdentity, HttpStatus.OK)
            else
                ResponseEntity(UserIdentity(), HttpStatus.OK)
        } catch ( e: Exception) {
            if(e is DataIntegrityViolationException)
                throw DatabaseDuplicateException(e.rootCause!!.message!!)
        }
        return null
    }

    @GetMapping("/getUserByPhoneNumber")
    public fun getUserByPhoneNumber(@RequestParam(value = "phoneNumber") body: String) : ResponseEntity<UserIdentity>? {
        return try {
            val userIdentity = userIdentityService.getUserIdentityByPhoneNumber(body)
            ResponseEntity(userIdentity, HttpStatus.OK)
        } catch (e : EmptyResultDataAccessException) {
            ResponseEntity(UserIdentity("null","null"), HttpStatus.OK)
        }
    }
}