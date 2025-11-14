package ru.lewicki.taskmanagerspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lewicki.taskmanagerspring.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
