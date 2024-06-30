package com.example.umcmission.review;

import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.domain.Review;
import com.example.umcmission.repository.RestaurantRepository;
import com.example.umcmission.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ReviewTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void testFindAllByRestaurant() {
        // Given
        Long restaurantId = 1L;
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow();

        // When
        Page<Review> reviews = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(0, 10));

        // Then
        assertNotNull(reviews);
        assertTrue(reviews.hasContent());
        System.out.println(reviews.getContent().toString());
    }
}

