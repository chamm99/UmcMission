package com.example.umc6th.domain;

import com.example.umc6th.domain.common.BaseEntity;
import com.example.umc6th.domain.mapping.UserFAQ;
import com.example.umc6th.domain.photo.FAQPhoto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FAQ extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String title;

    @OneToMany(mappedBy = "faq", cascade = CascadeType.ALL)
    private List<UserFAQ> userFAQList = new ArrayList<>();

    @OneToMany(mappedBy = "faq", cascade = CascadeType.ALL)
    private List<FAQPhoto> faqPhotoList = new ArrayList<>();
}
