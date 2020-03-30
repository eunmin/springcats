package com.eunmin.spring.cats.dto

import com.eunmin.spring.cats.domain.UserException

case class ErrorPayload(code: Int, message: String)

object ErrorPayload {
  def fromDomain(e: UserException): ErrorPayload = ErrorPayload(e.code, e.message)
}