package com.comparus.assessment.repository;

import com.comparus.assessment.model.User;
import com.comparus.assessment.sql.SqlGenerator;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;


@AllArgsConstructor
public class UserRepositoryDbImpl implements UserRepository {

    private final SqlGenerator sqlGenerator;
    private final JdbcClient jdbcClient;


    @Override
    public Iterable<User> findAll() {
        return jdbcClient.sql(sqlGenerator.generateSqlQuery()).query(User.class).list();
    }
}
