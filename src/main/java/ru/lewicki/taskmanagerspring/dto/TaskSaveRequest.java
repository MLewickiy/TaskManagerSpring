package ru.lewicki.taskmanagerspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskSaveRequest {

    private String title;
    private String description;
    private String tags;

}
