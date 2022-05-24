package com.beaconfire.pp_webservice_restful.domain.hibernate;

import com.beaconfire.pp_webservice_restful.domain.Quiz;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

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
}
