package com.example.umcmission.repository;

import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.Restaurant;
import com.example.umcmission.domain.User;
import com.example.umcmission.domain.enums.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByRestaurant(Restaurant restaurant, PageRequest of);
}
