package com.example.umcmission.repository;

import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.domain.Review;
import com.example.umcmission.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByRestaurant(Restaurant restaurant, PageRequest of);

    Page<Review> findAllByUser(User user, PageRequest of);
}
