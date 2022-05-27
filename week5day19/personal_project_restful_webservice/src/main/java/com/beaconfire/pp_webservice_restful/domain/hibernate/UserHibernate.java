package com.beaconfire.pp_webservice_restful.domain.hibernate;

import com.beaconfire.pp_webservice_restful.domain.User;
import lombok.*;

import javax.persistence.*;

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
}
