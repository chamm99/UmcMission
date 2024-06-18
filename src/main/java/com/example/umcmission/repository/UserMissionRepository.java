package com.example.umcmission.repository;

import com.example.umcmission.domain.enums.MissionStatus;
import com.example.umcmission.domain.mapping.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByMissionIdAndStatus(Long missionId, MissionStatus missionStatus);
}
