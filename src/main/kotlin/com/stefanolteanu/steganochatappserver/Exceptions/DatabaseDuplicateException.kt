package com.stefanolteanu.steganochatappserver.Exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DatabaseDuplicateException(message : String) : RuntimeException(message) {

}