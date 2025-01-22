package com.github.cchillen.task;

import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.Template;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Path("/")
public class TaskResource {

    private final TaskRepository repository;
    private final TaskMapper mapper;
    private final Template task;

    public TaskResource(TaskRepository repository, TaskMapper mapper, Template task) {
        this.repository = repository;
        this.mapper = mapper;
        this.task = task;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getTasks() {
        List<Task> tasks = repository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
        return task.data("tasks", tasks);
    }
}
