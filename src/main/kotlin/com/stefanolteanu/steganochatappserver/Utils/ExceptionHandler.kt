package com.stefanolteanu.steganochatappserver.Utils

import com.stefanolteanu.steganochatappserver.Exceptions.DatabaseDuplicateException
import org.hibernate.dialect.Database
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletResponse

@RestControllerAdvice
public class ExceptionHandler {

    @ExceptionHandler(DatabaseDuplicateException::class)
    public fun handleDatabaseDuplicateException(databaseDuplicateException: DatabaseDuplicateException, httpServletResponse: HttpServletResponse) : String {
        httpServletResponse.status = 500
        return databaseDuplicateException.message!!
    }


}