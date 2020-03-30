package com.eunmin.spring.cats.repository.impl

import com.eunmin.spring.cats.domain.{DuplicateUser, UserNotFound}
import com.eunmin.spring.cats.dto.UserDocument
import com.eunmin.spring.cats.repository.UserRepository
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(mongoTemplate: MongoTemplate) extends UserRepository {
  override def create(userDocument: UserDocument): UserDocument = try {
    mongoTemplate.insert(userDocument)
  } catch {
    case e: DuplicateKeyException => throw DuplicateUser(userDocument.id)
  }

  override def get(id: String): UserDocument = {
    val userDocument = mongoTemplate.findById(id, classOf[UserDocument])
    if (userDocument == null) {
      throw UserNotFound(id)
    } else {
      userDocument
    }
  }
}
