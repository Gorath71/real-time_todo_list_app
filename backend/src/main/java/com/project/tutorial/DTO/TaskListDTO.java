package com.project.tutorial.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskListDTO {

    @NotBlank
    private String name;
}
