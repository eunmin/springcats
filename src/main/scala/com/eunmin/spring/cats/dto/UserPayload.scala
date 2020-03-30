package com.eunmin.spring.cats.dto

import com.eunmin.spring.cats.domain.User

case class UserPayload(id: String, name: String)

object UserPayload {
  def fromDomain(user: User): UserPayload = UserPayload(user.id.value, user.name.value)
}
