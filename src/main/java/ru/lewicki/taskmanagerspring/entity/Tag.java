package ru.lewicki.taskmanagerspring.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tag extends BaseEntity {

    private User user;
    private String tag;
}
