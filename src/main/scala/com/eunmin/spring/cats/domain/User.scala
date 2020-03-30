package com.eunmin.spring.cats.domain

sealed class UserException(val code: Int, val message: String) extends RuntimeException
case class UseridLimitExceeded(id: String) extends UserException(-1401, s"id $id is too long (maximum is 16)")
case class UsernameLimitExceeded(name: String) extends UserException(-1402, "name $name is too long (maximum is 18)")
case class UserNotFound(id: String) extends UserException(-1404, "userid $id is not found")
case class DuplicateUser(id: String) extends UserException(-1405, "userid $id is already exists")


object Userid {
  def apply(value: String): Userid =
    if (value.length > 16) {
      throw UseridLimitExceeded(value)
    } else {
      Userid(value)
    }
}
case class Userid(value: String)


object Username {
  def apply(value: String): Username =
    if (value.length > 16) {
      throw UsernameLimitExceeded(value)
    } else {
      Username(value)
    }
}
case class Username(value: String)


case class User(id: Userid, name: Username)

