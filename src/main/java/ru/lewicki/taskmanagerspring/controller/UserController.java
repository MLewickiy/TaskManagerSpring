package ru.lewicki.taskmanagerspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lewicki.taskmanagerspring.dto.UserResponse;
import ru.lewicki.taskmanagerspring.dto.UserSaveRequest;
import ru.lewicki.taskmanagerspring.service.UserService;

import java.util.List;

@RestController
@RequestMapping({"/user"})
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserSaveRequest userSaveRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userSaveRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));

    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }
}