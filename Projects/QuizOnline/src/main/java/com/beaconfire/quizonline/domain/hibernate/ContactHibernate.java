package com.beaconfire.quizonline.domain.hibernate;

import com.beaconfire.quizonline.domain.Contact;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Contact")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactHibernate extends Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private int contactId;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "subject")
    private String subject;
    @Column(name = "message")
    private String message;
}
