package com.example.umcmission.repository;

import com.example.umcmission.domain.Mission;
import com.example.umcmission.domain.User;
import com.example.umcmission.domain.enums.MissionStatus;
import com.example.umcmission.domain.mapping.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByMissionIdAndStatus(Long missionId, MissionStatus missionStatus);

    @Query("SELECT a.mission FROM UserMission a WHERE a.user = :user AND a.status = :status")
    Page<Mission> findAllByUserAndInChallenging(@Param("user") User user, @Param("status") MissionStatus status, Pageable of);
}
