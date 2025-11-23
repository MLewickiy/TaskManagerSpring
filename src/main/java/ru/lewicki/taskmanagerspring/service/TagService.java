package ru.lewicki.taskmanagerspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lewicki.taskmanagerspring.dto.TagResponse;
import ru.lewicki.taskmanagerspring.dto.TagSaveRequest;
import ru.lewicki.taskmanagerspring.entity.Tag;
import ru.lewicki.taskmanagerspring.mapper.TagMapper;
import ru.lewicki.taskmanagerspring.repository.TagRepository;

@RequiredArgsConstructor
@Service
public class TagService {
    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public TagResponse create(TagSaveRequest tagSaveRequest) {
        Tag tag = tagRepository.save(tagMapper.toEntity(tagSaveRequest));
        return tagMapper.toResponse(tag);
    }
}
