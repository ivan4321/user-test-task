package com.comparus.assessment.repository;

import com.comparus.assessment.model.User;

public interface UserRepository {
    Iterable<User> findAll(User user);
}
