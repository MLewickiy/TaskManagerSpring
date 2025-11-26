package ru.lewicki.taskmanagerspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lewicki.taskmanagerspring.dto.TaskResponse;
import ru.lewicki.taskmanagerspring.dto.TaskSaveRequest;
import ru.lewicki.taskmanagerspring.entity.Task;
import ru.lewicki.taskmanagerspring.mapper.TaskMapper;
import ru.lewicki.taskmanagerspring.mapper.UserMapper;
import ru.lewicki.taskmanagerspring.repository.TaskRepository;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserMapper userMapper;

    public TaskResponse create(TaskSaveRequest taskSaveRequest) {
        Task task = taskRepository.save(taskMapper.toEntity(taskSaveRequest));
        return taskMapper.toResponse(task);
    }

    public TaskResponse getTaskById(Long id) {
        return TaskMapper.toResponse(taskRepository.findById(id).orElseThrow());

    }
}
