package com.comparus.assessment.configuration;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class UserMapping {
    @NotEmpty(message = "Column for id field is not mapped")
    private String id;
    @NotEmpty(message = "Column for username field is not mapped")
    private String username;
    @NotEmpty(message = "Column for name field is not mapped")
    private String name;
    @NotEmpty(message = "Column for surname field is not mapped")
    private String surname;
}
