package com.beaconfire.quizonline.domain;

import lombok.*;

@Getter
@Setter
@ToString
public abstract class Category {
    private int categoryId;
    private String name;
    private String imageUrl;
}
