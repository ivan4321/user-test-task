package com.comparus.assessment.configuration;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

@Data
@Validated
public class DataSourceConfig {
    @NotEmpty
    private String name;
    private String strategy;
    @NotEmpty
    private String url;
    @NotEmpty
    private String table;
    @NotEmpty
    private String user;
    @NotEmpty
    private String password;
    @NotNull
    private UserMapping mapping;
}
