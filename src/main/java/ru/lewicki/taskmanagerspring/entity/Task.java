package ru.lewicki.taskmanagerspring.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.enumiration.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Task extends BaseEntity { // класс таск наследуется от абстрактного класса BaseEntity
    private String title; // поле название
    private String description; // поле описание
    private User user; // поле юзер
    private LocalDateTime complete; // поле дата завершения
    // enum
    private TaskStatus status; // поле статус
    // Флаг
    private boolean isCompleted; // поле задача завершена
    // Лист для хранения тегов
    private List<String> tags; // поле теги
    // Конструктор класса с обязательным параметром название
    public Task(String title) {
        this.title = title;
    }
    // Сигнатура метода
    public String getTitle() { // тело метода
        return title;
    }
}