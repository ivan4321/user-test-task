package com.comparus.assessment.sql;

import com.comparus.assessment.configuration.UserMapping;
import org.springframework.stereotype.Component;

@Component
public class SqlGeneratorFactory {

    public SqlGenerator createGenerator(UserMapping mapping, String table){
        return new SimpleSqlGenerator(mapping, table);
    }
}
