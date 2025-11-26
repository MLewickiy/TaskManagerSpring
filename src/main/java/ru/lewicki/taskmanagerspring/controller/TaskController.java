package ru.lewicki.taskmanagerspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lewicki.taskmanagerspring.dto.TagResponse;
import ru.lewicki.taskmanagerspring.dto.TaskResponse;
import ru.lewicki.taskmanagerspring.dto.TaskSaveRequest;
import ru.lewicki.taskmanagerspring.service.TaskService;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody TaskSaveRequest taskSaveRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(taskSaveRequest));
    }

    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }
}
