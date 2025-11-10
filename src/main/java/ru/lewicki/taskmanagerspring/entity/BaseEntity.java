package ru.lewicki.taskmanagerspring.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseEntity {
    private long id;
    private LocalDateTime created;
    private LocalDateTime updated;
}
