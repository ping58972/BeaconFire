package com.beaconfire.quizonline.domain.hibernate;

import com.beaconfire.quizonline.domain.Address;
import com.beaconfire.quizonline.domain.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Address")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressHibernate extends Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;
    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private int zipcode;
    @Column
    private String country;
    @OneToOne(fetch = FetchType.LAZY)//, mappedBy = "address")
    @JoinColumn(name = "address_id")
    private UserHibernate userHibernate;
//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "address")
//    @JoinColumn(name = "address_id")
//    private UserHibernate userHibernate;

//    @OneToOne(orphanRemoval = true)
//    @JoinTable(name = "address_user_hibernate",
//            joinColumns = @JoinColumn(name = "address_hibernate_address_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_hibernate_user_id"))
//    private UserHibernate userHibernate;

}
