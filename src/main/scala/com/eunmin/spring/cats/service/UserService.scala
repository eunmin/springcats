package com.eunmin.spring.cats.service

import com.eunmin.spring.cats.dto.{CreateUserInput, UserDocument, UserPayload}
import com.eunmin.spring.cats.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(userRepository: UserRepository) {
  def get(id: String): UserPayload = {
    val userDocument = userRepository.get(id)
    val user = userDocument.toDomain()
    UserPayload.fromDomain(user)
  }

  def create(input: CreateUserInput): UserPayload = {
    val user = input.toDomain()
    val userDocument = UserDocument.fromDomain(user)
    val createdUserDocument = userRepository.create(userDocument)
    val createdUser = createdUserDocument.toDomain()
    UserPayload.fromDomain(createdUser)
  }
}
