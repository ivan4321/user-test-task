package com.comparus.assessment.configuration;

import com.comparus.assessment.repository.UserRepository;
import com.comparus.assessment.repository.UserRepositoryDbImpl;
import com.comparus.assessment.sql.SqlGenerator;
import com.comparus.assessment.sql.SqlGeneratorFactory;
import lombok.AllArgsConstructor;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@AllArgsConstructor
public class RepositoryConfig {

    private final DatasourceProperties dataSourcesProperties;


    @Bean
    public HashMap<String, UserRepository> userRepositories(SqlGeneratorFactory sqlGeneratorFactory) {
        HashMap<String, UserRepository> repositoryMap = new HashMap<>();
        dataSourcesProperties.getDataSources().forEach(config -> {
            SqlGenerator sqlGenerator = sqlGeneratorFactory.createGenerator(config.getMapping(), config.getTable());
            JdbcClient jdbcClient = JdbcClient.create(createDataSource(config));
            repositoryMap.put(config.getName(), new UserRepositoryDbImpl(sqlGenerator, jdbcClient));
        });
        return repositoryMap;
    }

    private DataSource createDataSource(DataSourceConfig dataSourceConfig) {
        return DataSourceBuilder.create()
                .url(dataSourceConfig.getUrl())
                .username(dataSourceConfig.getUser())
                .password(dataSourceConfig.getPassword())
                //TODO driver by strategy
                .driverClassName("org.postgresql.Driver")
                .build();
    }


}
