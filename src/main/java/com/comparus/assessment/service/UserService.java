package com.comparus.assessment.service;

import com.comparus.assessment.api.UserFilter;
import com.comparus.assessment.model.User;
import com.comparus.assessment.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class UserService {
    private final HashMap<String, UserRepository> userRepositories;
    private final ObjectMapper objectMapper;

    public List<User> getUsers(UserFilter userFilter){

        User user = objectMapper.convertValue(userFilter, User.class);

        return userRepositories.values().parallelStream()
                .flatMap(userRepository -> {
                    Iterable<User> iterable = userRepository.findAll(user);
                    return StreamSupport.stream(iterable.spliterator(), false);
                }).toList();
    }
}
