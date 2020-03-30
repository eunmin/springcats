package com.eunmin.spring.cats.repository

import com.eunmin.spring.cats.dto.UserDocument

trait UserRepository {
  def create(userDocument: UserDocument): UserDocument
  def get(id: String): UserDocument
}
