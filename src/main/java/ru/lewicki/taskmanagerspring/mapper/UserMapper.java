package ru.lewicki.taskmanagerspring.mapper;

import org.springframework.stereotype.Component;
import ru.lewicki.taskmanagerspring.dto.UserResponse;
import ru.lewicki.taskmanagerspring.dto.UserSaveRequest;
import ru.lewicki.taskmanagerspring.entity.User;

@Component
public class UserMapper {

    public User toEntity(UserSaveRequest userSaveRequest) {
        User user = new User();
        user.setLogin(userSaveRequest.getLogin());
        user.setFirstname(userSaveRequest.getFirstname());
        user.setLastname(userSaveRequest.getLastname());
        return user;
    }

    public UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setLogin(user.getLogin());
        userResponse.setFirstname(user.getFirstname());
        userResponse.setLastname(user.getLastname());
        return userResponse;
    }
}
