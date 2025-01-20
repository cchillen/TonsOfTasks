package com.github.cchillen.task;

import jakarta.validation.constraints.NotEmpty;

public record Task (
        Long taskId,
        @NotEmpty(message = "{Task.title.required}")
        String title,
        String description,
        @NotEmpty(message = "{Task.isCompleted.required}")
        boolean isCompleted
){
}
