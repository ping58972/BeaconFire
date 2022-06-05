package com.beaconfire.quizrestful.domain.hibernate;

import com.beaconfire.quizrestful.domain.Question;
import com.beaconfire.quizrestful.domain.Quiz;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "Question")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionHibernate extends Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer questionId;
    @Column(name="category_id")
    private Integer categoryId;
    @Column(name="description")
    private String description;
    @Column(name="type")
    private String type;
    @Column(name="is_active")
    private Boolean isActive;
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(mappedBy = "questions", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<QuizHibernate> quizzes = new ArrayList<>();

}
