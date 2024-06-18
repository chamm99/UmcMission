package com.example.umcmission.annotation.validator;

import com.example.umcmission.annotation.ChallengeMission;
import com.example.umcmission.web.repository.UserMissionRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionChallengeValidator implements ConstraintValidator<ChallengeMission, Long> {

    private final UserMissionRepository userMissionRepository;

    @Override
    public void initialize(ChallengeMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        boolean isMissionChallenged = userMissionRepository.existsByMissionIdAndStatus(missionId, MissionStatus.CHALLENGING);

        if (isMissionChallenged) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("해당 미션은 이미 도전 중입니다.").addConstraintViolation();
        }

        return !isMissionChallenged;
    }
}
