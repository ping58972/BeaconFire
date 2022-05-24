package com.beaconfire.quizonline.domain.hibernate;

import com.beaconfire.quizonline.domain.Category;
import com.beaconfire.quizonline.domain.Choice;
import com.beaconfire.quizonline.domain.Question;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "Question")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionHibernate extends Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int questionId;
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    private String type;
    @Column(name = "is_active")
    private boolean isActive;
//    @ManyToOne
//    @JoinColumn(name = "question_id")
//    @ToString.Exclude
//    private CategoryHibernate category;
//
//    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
//    @ToString.Exclude
//    private Set<ChoiceHibernate> choices;
//
//    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private Set<QuizQuestionHibernate> qqSet = new HashSet<>(0);

}
