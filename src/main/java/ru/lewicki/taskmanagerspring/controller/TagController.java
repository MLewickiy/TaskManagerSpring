package ru.lewicki.taskmanagerspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lewicki.taskmanagerspring.dto.TagResponse;
import ru.lewicki.taskmanagerspring.dto.TagSaveRequest;
import ru.lewicki.taskmanagerspring.service.TagService;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @PostMapping
    public ResponseEntity<TagResponse> create (@RequestBody TagSaveRequest tagSaveRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tagService.create(tagSaveRequest));
    }
}
