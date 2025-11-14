package ru.lewicki.taskmanagerspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lewicki.taskmanagerspring.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
