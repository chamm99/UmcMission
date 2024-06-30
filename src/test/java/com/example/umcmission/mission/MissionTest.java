package com.example.umcmission.mission;

import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.domain.Review;
import com.example.umcmission.domain.User;
import com.example.umcmission.domain.enums.MissionStatus;
import com.example.umcmission.repository.UserMissionRepository;
import com.example.umcmission.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class MissionTest {

    @Autowired
    private UserMissionRepository userMissionRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAllMissions() {
        // Given
        Long userId = 1L;
        User user = userRepository.findById(userId).orElseThrow();

        // When
        Page<Mission> missions = userMissionRepository.findAllByUserAndInChallenging(user, MissionStatus.CHALLENGING, PageRequest.of(0, 10));

        // Then
        assertNotNull(missions);
        assertTrue(missions.hasContent());
        missions.getContent().forEach(System.out::println);
    }
}



