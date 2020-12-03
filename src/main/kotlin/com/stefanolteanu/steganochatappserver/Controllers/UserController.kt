package com.stefanolteanu.steganochatappserver.Controllers

import com.stefanolteanu.steganochatappserver.Models.UserIdentity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping("/enrollNewUser")
    public fun enrollUser(@RequestBody body: UserIdentity) : ResponseEntity<UserIdentity> {
        println(body.phoneNumber)
        return ResponseEntity(body, HttpStatus.OK)
    }
}