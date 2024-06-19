package com.example.umcmission.domain;

import com.example.umcmission.domain.common.BaseEntity;
import com.example.umcmission.domain.mapping.UserRestaurantReview;
import com.example.umcmission.domain.photo.RestaurantPhoto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean isOpen;
    private String address;
    private String type;
    private String status;
    private LocalDate inactiveDate;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<UserRestaurantReview> userRestaurantReviewList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<RestaurantPhoto> restaurantPhotoList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    public void updateRegion(Region region) {
        this.region = region;
    }
}
