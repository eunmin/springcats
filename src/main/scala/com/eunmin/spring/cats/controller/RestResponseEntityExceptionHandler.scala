package com.eunmin.spring.cats.controller

import com.eunmin.spring.cats.domain.{DuplicateUser, UserException, UserNotFound, UseridLimitExceeded, UsernameLimitExceeded}
import com.eunmin.spring.cats.dto.ErrorPayload
import org.springframework.http.{HttpHeaders, HttpStatus}
import org.springframework.web.bind.annotation.{ControllerAdvice, ExceptionHandler}
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler() {
  @ExceptionHandler(value = Array(classOf[DuplicateUser]))
  def handleDuplicatedUserException(e: UserException, request: WebRequest) =
    handleExceptionInternal(e, ErrorPayload.fromDomain(e), new HttpHeaders(), HttpStatus.CONFLICT, request)

  @ExceptionHandler(value = Array(classOf[UserNotFound]))
  def handleUserNotFoundException(e: UserException, request: WebRequest) =
    handleExceptionInternal(e, ErrorPayload.fromDomain(e), new HttpHeaders(), HttpStatus.NOT_FOUND, request)

  @ExceptionHandler(value = Array(classOf[UseridLimitExceeded], classOf[UsernameLimitExceeded]))
  def handleLimitExceededException(e: UserException, request: WebRequest) =
    handleExceptionInternal(e, ErrorPayload.fromDomain(e), new HttpHeaders(), HttpStatus.BAD_REQUEST, request)
}
