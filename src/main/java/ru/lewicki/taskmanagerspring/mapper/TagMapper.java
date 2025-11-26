package ru.lewicki.taskmanagerspring.mapper;

import org.springframework.stereotype.Component;
import ru.lewicki.taskmanagerspring.dto.TagResponse;
import ru.lewicki.taskmanagerspring.dto.TagSaveRequest;
import ru.lewicki.taskmanagerspring.entity.Tag;

@Component
public class TagMapper {

    public Tag toEntity(TagSaveRequest tagSaveRequest) {
        Tag tag = new Tag();
        tag.setTag(tagSaveRequest.getTag());
        return tag;
    }

    public static TagResponse toResponse(Tag tag) {
        TagResponse tagResponse = new TagResponse();
        tagResponse.setTag(tag.getTag());
        return tagResponse;
    }
}
