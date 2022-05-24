package com.beaconfire.quizonline.domain.hibernate;

import com.beaconfire.quizonline.domain.Quiz;
import com.beaconfire.quizonline.domain.QuizQuestion;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Map;

@Entity
@Table(name = "Quiz")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizHibernate extends Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private int quizId;
    @Column(name = "quiz_name")
    private String quizName;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "start_time")
    private Timestamp startTime;
    @Column(name = "end_time")
    private Timestamp endTime;

    //    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    @ToString.Exclude
//    private UserHibernate userQuiz;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    @ToString.Exclude
//    private CategoryHibernate category;

}
