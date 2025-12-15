package ru.lewicki.taskmanagerspring.mapper;

import org.springframework.stereotype.Component;
import ru.lewicki.taskmanagerspring.dto.UserResponse;
import ru.lewicki.taskmanagerspring.dto.UserSaveRequest;
import ru.lewicki.taskmanagerspring.entity.User;
import ru.lewicki.taskmanagerspring.repository.UserRepository;

import java.util.List;

@Component
public class UserMapper {

    private final UserRepository userRepository;

    public UserMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User toEntity(UserSaveRequest userSaveRequest) {
        User user = new User();
        user.setLogin(userSaveRequest.getLogin()); // Логин
        user.setFirstname(userSaveRequest.getFirstname()); // Имя
        user.setLastname(userSaveRequest.getLastname());// Фамилия
        user.setEmail(userSaveRequest.getEmail()); // Почта
        user.setAge(Integer.parseInt(userSaveRequest.getAge())); // Возраст

        return user;
    }

    public UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setLogin(user.getLogin()); // Логин
        userResponse.setFirstname(user.getFirstname()); // Имя
        userResponse.setLastname(user.getLastname()); // Фамилия
        userResponse.setEmail(user.getEmail()); // Почта
        userResponse.setAge(user.getAge()); // Возраст

        return userResponse;
    }

    public List<UserResponse> toDtoList(List<User> users) { // Запрос пользователей
        return users.stream()
                .map(this::toResponse)
                .toList();
    }
}
