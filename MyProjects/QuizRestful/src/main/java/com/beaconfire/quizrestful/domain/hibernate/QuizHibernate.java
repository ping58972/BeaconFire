package com.beaconfire.quizrestful.domain.hibernate;

import com.beaconfire.quizrestful.domain.Question;
import com.beaconfire.quizrestful.domain.Quiz;
import com.beaconfire.quizrestful.domain.QuizQuestion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Quiz")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuizHibernate extends Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private int quizId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "quiz_name")
    private String quizName;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "start_time")
    private Timestamp startTime;
    @Column(name = "end_time")
    private Timestamp endTime;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Quiz_Question",
            joinColumns = {@JoinColumn(name = "quiz_id")},
            inverseJoinColumns =  @JoinColumn(name="question_id")
    )
    private List<QuestionHibernate> questions = new ArrayList<>();

//    @OneToMany(mappedBy = "quizHibernate", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "qq_id")
//    private List<QuizQuestionHibernate> answers = new ArrayList<>();
//
//    public void addAnswer(QuizQuestionHibernate qq){
//        this.answers.add(qq);
//    }
}
