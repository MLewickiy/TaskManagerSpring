package ru.lewicki.taskmanagerspring.mapper;

import org.springframework.stereotype.Component;
import ru.lewicki.taskmanagerspring.dto.UserResponse;
import ru.lewicki.taskmanagerspring.dto.UserSaveRequest;
import ru.lewicki.taskmanagerspring.entity.User;
import ru.lewicki.taskmanagerspring.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final UserRepository userRepository;

    public UserMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User toEntity(UserSaveRequest userSaveRequest) {
        User user = new User();
        user.setLogin(userSaveRequest.getLogin());
        user.setFirstname(userSaveRequest.getFirstname());
        user.setLastname(userSaveRequest.getLastname());
        user.setEmail(userSaveRequest.getEmail());
        user.setAge(Integer.parseInt(userSaveRequest.getAge()));

        return user;
    }

    public UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setLogin(user.getLogin());
        userResponse.setFirstname(user.getFirstname());
        userResponse.setLastname(user.getLastname());
        userResponse.setEmail(user.getEmail());
        userResponse.setAge(user.getAge());

        return userResponse;
    }

    public List<UserResponse> toDtoList(List<User> users) {
        return users.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
//                .toList();
    }
}
