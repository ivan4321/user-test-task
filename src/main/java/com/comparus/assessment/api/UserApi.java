package com.comparus.assessment.api;

import com.comparus.assessment.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Tag(name = "user", description = "the user API")
public interface UserApi {

    @GetMapping(value = "/users")
    List<User> getUsers(UserFilter userFilter);
}
