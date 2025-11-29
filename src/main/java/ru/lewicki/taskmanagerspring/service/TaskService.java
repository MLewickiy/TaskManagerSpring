package ru.lewicki.taskmanagerspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lewicki.taskmanagerspring.dto.TaskResponse;
import ru.lewicki.taskmanagerspring.dto.TaskSaveRequest;
import ru.lewicki.taskmanagerspring.entity.Task;
import ru.lewicki.taskmanagerspring.mapper.TaskMapper;
import ru.lewicki.taskmanagerspring.repository.TaskRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskResponse create(TaskSaveRequest taskSaveRequest) {
        Task task = taskRepository.save(taskMapper.toEntity(taskSaveRequest));
        return taskMapper.toResponse(task);
    }

    public TaskResponse getTaskById(Long id) { // Получить задачу по id (Сделать маппинг)//
        return taskMapper.toResponse(taskRepository.findById(id).orElseThrow());

    }
    public List<TaskResponse> getAllTasks() { // Получить все задачи
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.taskDtoList(tasks);
    }
}
