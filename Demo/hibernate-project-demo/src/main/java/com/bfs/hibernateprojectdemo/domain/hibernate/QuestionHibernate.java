package com.bfs.hibernateprojectdemo.domain.hibernate;

import com.bfs.hibernateprojectdemo.domain.Question;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="question")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionHibernate extends Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(nullable = false)
    private String description;

    @Column(name = "is_active")
    private boolean isActive;
}
