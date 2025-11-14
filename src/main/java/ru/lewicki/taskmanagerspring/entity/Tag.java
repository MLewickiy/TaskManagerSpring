package ru.lewicki.taskmanagerspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tag", uniqueConstraints = {@UniqueConstraint(name = "tag_id_unique", columnNames = "id")})
    /**
    * Table(name = "tag") - Указывает, что класс (сущность) должен быть сопоставлен с таблицей базы данных под именем tag
    * uniqueConstraints - Определяет уникальные ограничения (уникальные ключи) на уровне таблицы. Это значит: в указанных столбцах не может быть повторяющихся значений (или комбинаций значений).
    * name = "tag_id_unique" - имя ограничения в БД (используется для ссылок, логов, миграций).
    * columnNames = "id" - указывает, что уникальность гарантируется для столбца id
    */

public class Tag extends BaseEntity {
    @Id
    @Column(name = "id", unique = true)
    /**
     * @Column в Java — часть JPA (Java Persistence API), задающая правила отображения поля класса на столбец таблицы базы данных.
     * name = "id" - Указывает имя столбца в БД, к которому привязывается поле класса.
     * unique = true - Гарантирует, что в столбце не может быть повторяющихся значений — все значения должны быть уникальными.
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_id_generator")
    /**
     * @GeneratedValue - Указывает, что значение поля (первичного ключа) должно генерироваться автоматически.
     * strategy = GenerationType.SEQUENCE - способ генерации: использовать последовательность БД (аналог SEQUENCE в SQL).
     * generator = "tag_id_generator" — имя генератора, который будет использоваться (связывает с @SequenceGenerator).
     */
    @SequenceGenerator(name = "tag_id_generator", sequenceName = "tag_sequence_id", allocationSize = 1)
    /**
     * @SequenceGenerator - Описывает, как именно JPA должна работать с последовательностью БД.
     * name = "tag_id_generator" — имя генератора (должно совпадать с generator в @GeneratedValue). Это логический идентификатор внутри JPA.
     * sequenceName = "tag_sequence_id" — имя реальной последовательности в БД. JPA будет обращаться к объекту БД с этим именем.
     * allocationSize = 1 — шаг увеличения значения. Означает: каждое новое значение = предыдущее +1.
     */
    private long id;
//    private User user;

    @Column(name = "tag", length = 128)
    private String tag;
}
