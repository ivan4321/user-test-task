package com.comparus.assessment.sql;

import com.comparus.assessment.configuration.UserMapping;

public class SimpleSqlGenerator implements SqlGenerator {

    private final String sql;

    public SimpleSqlGenerator(UserMapping mapping, String tableName) {
        this.sql = "SELECT " +
                mapping.getId() + " as id," +
                mapping.getUsername() + " as username," +
                mapping.getName() + " as name," +
                mapping.getSurname() + " as surname " +
                "FROM " +
                tableName;
    }


    @Override
    public String generateSqlQuery() {
        return sql;
    }


}
