package com.comparus.assessment.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {
    private String id;
    @Schema(description = "username for authentication", example = "destroyer100500")
    private String username;
    private String name;
    private String surname;
}
