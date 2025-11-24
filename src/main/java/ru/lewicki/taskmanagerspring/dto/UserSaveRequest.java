package ru.lewicki.taskmanagerspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserSaveRequest {

    private String login;
    private String firstname;
    private String lastname;
}
