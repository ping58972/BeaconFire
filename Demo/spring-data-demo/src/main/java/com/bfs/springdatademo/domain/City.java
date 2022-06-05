package com.bfs.springdatademo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "countrycode")
    private String countryCode;

    @Column(name = "district")
    private String district;

    @Column(name = "population")
    private Integer population;
}
