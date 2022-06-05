package com.beaconfire.quizrestful.domain.hibernate;

import com.beaconfire.quizrestful.domain.User;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "User")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserHibernate extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
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
    @Column(name = "address_id")
    private Integer addressId;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserHibernate)) return false;
        UserHibernate that = (UserHibernate) o;
        return getEmail().equals(that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }
}
