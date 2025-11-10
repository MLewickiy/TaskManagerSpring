package ru.lewicki.taskmanagerspring.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User extends BaseEntity { // Класс пользователь наследуется от базовой сущности

    private String login; // поле логин
    private String firstname; // поле имя
    private String lastname; // поле фамилия
    private String email; // поле почта
    // Лист для хранения тегов
    private List<String> tags; // Поле лист упорядоченная колекция элементов в списке
    @Setter(AccessLevel.NONE) // исключение для сеттера при использования правил метода
    private int age; // поле возраст

    // Обязательное заполнение поля логин
    public User(String login) {
        this.login = login;
    }
    // Сигнатура метода
    public void setAge(int age)  { // тело метода начало
        if (age < 0) {
            System.out.println("Invalid age");
        } else {
            this.age = age;
            System.out.println("Age set to " + age);
        }
    } // тело метода конец
}
