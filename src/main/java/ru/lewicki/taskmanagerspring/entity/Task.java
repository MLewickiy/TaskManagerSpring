package ru.lewicki.taskmanagerspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.lewicki.taskmanagerspring.enumiration.TaskStatus;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task", uniqueConstraints = {@UniqueConstraint(name = "task_id_unique", columnNames = "id")})
public class Task extends BaseEntity { // класс таск наследуется от абстрактного класса BaseEntity
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_generator")
    @SequenceGenerator(name = "task_id_generator", sequenceName = "task_sequence_id", allocationSize = 1)
    private long id;

    private String title; // поле название
    private String description; // поле описание
//    private User user; // поле юзер
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