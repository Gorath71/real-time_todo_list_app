package com.project.tutorial.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private Long taskListId;
}
