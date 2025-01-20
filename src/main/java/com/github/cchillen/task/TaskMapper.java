package com.github.cchillen.task;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskMapper {
    public Task toDomain(TaskEntity entity) {
        return new Task(
                entity.id,
                entity.title,
                entity.description,
                entity.isCompleted
        );
    }

    public TaskEntity toEntity(Task domain) {
        TaskEntity task = new TaskEntity();
        task.id = domain.taskId();
        task.title = domain.title();
        task.description = domain.description();
        task.isCompleted = domain.isCompleted();

        return task;
    }
}
