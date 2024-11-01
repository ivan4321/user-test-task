package com.comparus.assessment.controller;

import com.comparus.assessment.api.UserApi;
import com.comparus.assessment.configuration.DatasourceProperties;
import com.comparus.assessment.model.User;
import com.comparus.assessment.repository.UserRepository;
import com.comparus.assessment.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public List<User> getUsers() {
       return userService.getUsers();
    }
}