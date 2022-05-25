package com.beaconfire.quizonline.domain.hibernate;

import com.beaconfire.quizonline.domain.Address;
import com.beaconfire.quizonline.domain.User;

import javax.persistence.*;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserHibernate extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "face_url")
    private String faceUrl;
//    @Column(name = "address_id")
//    private int addressId;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "userHibernate")
    @ToString.Exclude
    private AddressHibernate address;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_admin")
    private boolean isAdmin;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "address_id")
//    @ToString.Exclude
//    private AddressHibernate address;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private Set<FeedbackHibernate> feedbacks = new HashSet<>(0);
//
//    @OneToMany(mappedBy = "userQuiz", fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private Set<QuizHibernate> quizzes = new HashSet<>(0);
}
