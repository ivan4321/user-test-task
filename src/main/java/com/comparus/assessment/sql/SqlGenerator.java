package com.comparus.assessment.sql;

import com.comparus.assessment.configuration.DataSourceConfig;
import com.comparus.assessment.model.User;

public interface SqlGenerator {
    String generateSqlQuery();

    String generateSqlQuery(User user);


}
