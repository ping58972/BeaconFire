package com.beaconfire.quizonline.domain.hibernate;

import com.beaconfire.quizonline.domain.Feedback;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Feedback")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackHibernate extends Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private int feedbackId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "message")
    private String message;
    @Column(name = "rating")
    private int rating;
    @Column(name = "feedback_time")
    private Timestamp feedbackTime;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    @ToString.Exclude
//    private UserHibernate user;
}
