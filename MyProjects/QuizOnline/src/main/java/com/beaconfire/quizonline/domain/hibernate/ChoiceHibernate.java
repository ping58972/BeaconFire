package com.beaconfire.quizonline.domain.hibernate;

import com.beaconfire.quizonline.domain.Choice;
import com.beaconfire.quizonline.domain.Question;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Choice")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceHibernate extends Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choice_id")
    private int choiceId;
    @Column(name = "question_id")
    private int questionId;
    @Column(name = "choice_description")
    private String choiceDesription;
    @Column(name = "is_correct")
    private boolean isCorrect;

//    @ManyToOne
//    @JoinColumn(name = "question_id")
//    @ToString.Exclude
//    private QuestionHibernate question;
//
//    @OneToMany(mappedBy = "userChoice", fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private Set<QuizQuestionHibernate> quizzes = new HashSet<>(0);
}
