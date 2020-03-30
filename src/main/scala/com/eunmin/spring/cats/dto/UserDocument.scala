package com.eunmin.spring.cats.dto

import com.eunmin.spring.cats.domain.{User, Userid, Username}
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.{Document, Field}

@Document(value = "user")
case class UserDocument(@Id id: String, @Field name: String) {
  def toDomain(): User = User(Userid(id), Username(name))
}

object UserDocument {
  def fromDomain(user: User): UserDocument = UserDocument(user.id.value, user.name.value)
}