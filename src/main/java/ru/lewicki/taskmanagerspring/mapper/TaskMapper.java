package ru.lewicki.taskmanagerspring.mapper;

import org.springframework.stereotype.Component;
import ru.lewicki.taskmanagerspring.dto.TaskResponse;
import ru.lewicki.taskmanagerspring.dto.TaskSaveRequest;
import ru.lewicki.taskmanagerspring.entity.Task;
import ru.lewicki.taskmanagerspring.repository.TaskRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    private final TaskRepository taskRepository;

    public TaskMapper(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Task toEntity(TaskSaveRequest taskSaveRequest) {
        Task task = new Task();
        task.setTitle(taskSaveRequest.getTitle()); // Название
        task.setDescription(taskSaveRequest.getDescription()); // Описание
        task.setTags(Collections.singletonList(taskSaveRequest.getTags())); // Тег
        return task;
    }

    public TaskResponse toResponse(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTitle(task.getTitle()); // Название
        taskResponse.setDescription(task.getDescription()); // Описание
        taskResponse.setTags(String.valueOf(task.getTags())); // Тег

        return taskResponse;
    }

    public List<TaskResponse> taskDtoList(List<Task> tasks) { // Получить все задачи
        return tasks.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
