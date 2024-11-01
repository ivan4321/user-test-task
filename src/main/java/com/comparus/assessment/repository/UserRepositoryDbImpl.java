package com.comparus.assessment.repository;

import com.comparus.assessment.model.User;
import com.comparus.assessment.sql.SqlGenerator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.Map;


@AllArgsConstructor
public class UserRepositoryDbImpl implements UserRepository {

    private final SqlGenerator sqlGenerator;
    private final JdbcClient jdbcClient;
    private final ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);


    @Override
    public Iterable<User> findAll(User user) {
        return jdbcClient.sql(sqlGenerator.generateSqlQuery(user))
                .params(objectMapper.convertValue(user, new TypeReference<Map<String,String>>() {}))
                .query(User.class)
                .list();
    }
}
