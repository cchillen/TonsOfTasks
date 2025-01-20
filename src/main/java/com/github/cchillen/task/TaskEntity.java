package com.github.cchillen.task;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.ZonedDateTime;
import java.util.Objects;

@Entity(name = "Task")
@Table(name = "task")
public class TaskEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    public Long id;

    @Column(name = "title")
    @NotEmpty(message = "{Task.title.required}")
    public String title;

    @Column(name = "description")
    public String description;

    @Column(name = "isCompleted", nullable = false)
    @NotEmpty(message = "{Task.isCompleted.required}")
    public boolean isCompleted;

    @Column(name = "createdAt", updatable = false, nullable = false)
    public ZonedDateTime createdAt;

    @Column(name = "updatedAt")
    public ZonedDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = ZonedDateTime.now();
        this.updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = ZonedDateTime.now();
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", name='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskEntity that = (TaskEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
