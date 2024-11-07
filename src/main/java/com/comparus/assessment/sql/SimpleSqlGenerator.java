package com.comparus.assessment.sql;

import com.comparus.assessment.configuration.UserMapping;
import com.comparus.assessment.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.stream.Collectors;

public class SimpleSqlGenerator implements SqlGenerator {

    private final String sql;

    private final ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    private final Map<String, String> columnMapping;

    public SimpleSqlGenerator(UserMapping mapping, String tableName) {
        Map<String, String> mappingMap = objectMapper.convertValue(mapping, new TypeReference<>() {
        });

        this.sql = "SELECT " +
                mappingMap.entrySet().stream().map(entry -> entry.getValue() + " as " + entry.getKey()).collect(Collectors.joining(",")) +
                " FROM " +
                tableName;
        this.columnMapping = objectMapper.convertValue(mapping, new TypeReference<>() {
        });
    }


    @Override
    public String generateSqlQuery() {
        return sql;
    }

    @Override
    public String generateSqlQuery(User user) {
        Map<String, String> paramMap = objectMapper.convertValue(user, new TypeReference<>() {
        });

        if (paramMap.isEmpty()) {
            return sql;
        }

        return sql
                + " WHERE "
                + paramMap.keySet().stream().map(param -> columnMapping.get(param) + "=:" + param).collect(Collectors.joining(","));
    }


}
