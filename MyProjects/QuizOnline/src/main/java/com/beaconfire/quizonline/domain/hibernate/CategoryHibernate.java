package com.beaconfire.quizonline.domain.hibernate;

import com.beaconfire.quizonline.domain.Category;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Category")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryHibernate extends Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "name")
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private Set<QuestionHibernate> questions = new HashSet<>(0);
//
//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private Set<QuizHibernate> quizzed = new HashSet<>(0);

}
