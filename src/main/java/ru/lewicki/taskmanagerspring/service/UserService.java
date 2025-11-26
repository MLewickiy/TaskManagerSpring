package ru.lewicki.taskmanagerspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lewicki.taskmanagerspring.dto.UserResponse;
import ru.lewicki.taskmanagerspring.dto.UserSaveRequest;
import ru.lewicki.taskmanagerspring.entity.User;
import ru.lewicki.taskmanagerspring.mapper.UserMapper;
import ru.lewicki.taskmanagerspring.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse create(UserSaveRequest userSaveRequest) {
        User user = userRepository.save(userMapper.toEntity(userSaveRequest));
        return userMapper.toResponse(user);
    }

    public UserResponse getUserById(Long id) {
        return userMapper.toResponse(userRepository.findById(id).orElseThrow());
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toDtoList(users);
    }
}