package ru.lewicki.taskmanagerspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lewicki.taskmanagerspring.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
