package com.comparus.assessment.configuration;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "conf")
@Validated
public class DatasourceProperties {

    @NotEmpty(message = "Data sources list cannot be empty")
    private List<DataSourceConfig> dataSources;

}
