package com.comparus.assessment.service;

import com.comparus.assessment.model.User;
import com.comparus.assessment.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class UserService {
    private final HashMap<String, UserRepository> userRepositories;

    public List<User> getUsers(){
        return userRepositories.values().parallelStream()
                .flatMap(userRepository -> {
                    Iterable<User> iterable = userRepository.findAll();
                    return StreamSupport.stream(iterable.spliterator(), false);
                }).toList();
    }
}
