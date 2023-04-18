package com.tweteroo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.User;
import com.tweteroo.api.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
@RequestMapping("/api/auth/sign-up")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping
  public void createUser(@RequestBody @Valid UserDTO req) {
    service.create(new User(req));
  }
}
