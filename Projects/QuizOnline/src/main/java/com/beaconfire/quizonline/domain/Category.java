package com.beaconfire.quizonline.domain;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
    private int categoryId;
    private String name;
    private String imageUrl;
}
