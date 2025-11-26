package ru.lewicki.taskmanagerspring.mapper;

import org.springframework.stereotype.Component;
import ru.lewicki.taskmanagerspring.dto.TaskResponse;
import ru.lewicki.taskmanagerspring.dto.TaskSaveRequest;
import ru.lewicki.taskmanagerspring.entity.Task;

import java.util.Collections;

@Component
public class TaskMapper {

    public Task toEntity(TaskSaveRequest taskSaveRequest) {
        Task task = new Task();
        task.setTitle(taskSaveRequest.getTitle());
        task.setDescription(taskSaveRequest.getDescription());
        task.setTags(Collections.singletonList(taskSaveRequest.getTags()));
        return task;
    }

    public static TaskResponse toResponse(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTitle(task.getTitle());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setTags(String.valueOf(task.getTags()));
        return taskResponse;
    }
}
