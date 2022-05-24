package com.beaconfire.quizonline.domain.hibernate;

import com.beaconfire.quizonline.domain.Question;
import com.beaconfire.quizonline.domain.QuizQuestion;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "QuizQuestion")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizQuestionHibernate extends QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qq_id")
    private int qqId;
    @Column(name = "quiz_id")
    private int quizId;
    @Column(name = "question_id")
    private int questionId;
    @Column(name = "user_choice_id")
    private int userChoiceId;
    @Column(name = "user_short_answer")
    private String userShortAnswer;
    @Column(name = "order_num")
    private int orderNum;
    @Column(name = "is_marked")
    private boolean isMarked;

//    @ManyToOne
//    @JoinColumn(name = "quiz_id")
//    @ToString.Exclude
//    private QuizHibernate quiz;
//
//    @ManyToOne
//    @JoinColumn(name = "question_id")
//    @ToString.Exclude
//    private QuestionHibernate question;
//
//    @ManyToOne
//    @JoinColumn(name = "user_choice_id")
//    @ToString.Exclude
//    private ChoiceHibernate userChoice;

}
