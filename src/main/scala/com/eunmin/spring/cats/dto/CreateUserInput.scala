package com.eunmin.spring.cats.dto

import com.eunmin.spring.cats.domain.{User, Userid, Username}

case class CreateUserInput(id: String, name: String) {
  def toDomain(): User = User(Userid(id), Username(name))
}


