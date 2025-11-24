package ru.lewicki.taskmanagerspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lewicki.taskmanagerspring.dto.UserResponse;
import ru.lewicki.taskmanagerspring.dto.UserSaveRequest;
import ru.lewicki.taskmanagerspring.entity.User;
import ru.lewicki.taskmanagerspring.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserSaveRequest userSaveRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userSaveRequest));
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}
