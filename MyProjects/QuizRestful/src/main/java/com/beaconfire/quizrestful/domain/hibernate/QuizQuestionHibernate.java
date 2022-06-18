package com.beaconfire.quizrestful.domain.hibernate;

import com.beaconfire.quizrestful.domain.QuizQuestion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Quiz_Question")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuizQuestionHibernate extends QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qq_id")
    private Integer qqId;
    @Column(name = "quiz_id")
    private Integer quizId;
    @Column(name = "question_id")
    private Integer questionId;
    @Column(name = "user_choice_id")
    private Integer userChoiceId;
    @Column(name = "user_short_answer")
    private String userShortAnswer;
    @Column(name = "order_num")
    private Integer orderNum;
    @Column(name = "is_marked")
    private Boolean isMarked;

//    @ManyToOne
//    @JoinColumn(name="quiz_id")
//    @JsonIgnore
//    @ToString.Exclude
//    private QuizHibernate quizHibernate;

}
