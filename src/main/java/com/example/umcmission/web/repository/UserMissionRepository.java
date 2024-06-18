package com.example.umcmission.web.repository;

import com.example.umcmission.domain.mapping.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
}
