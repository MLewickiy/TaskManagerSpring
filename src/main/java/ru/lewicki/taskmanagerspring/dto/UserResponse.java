package ru.lewicki.taskmanagerspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// Ответ
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserResponse {

    private Long id;
    private String login;
    private String firstname;
    private String lastname;
}
