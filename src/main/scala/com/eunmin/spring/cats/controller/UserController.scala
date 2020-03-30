package com.eunmin.spring.cats.controller

import com.eunmin.spring.cats.dto.{CreateUserInput, UserPayload}
import com.eunmin.spring.cats.service.UserService
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, PostMapping, RequestBody, RequestMapping, RestController}

@RestController
@RequestMapping(path = Array("/v1/users"))
class UserController(userService: UserService) {
  @GetMapping(path = Array("/{id}"))
  def get(@PathVariable id: String): UserPayload = userService.get(id)

  @PostMapping(path = Array("/"))
  def create(@RequestBody input: CreateUserInput): UserPayload = userService.create(input)
}
