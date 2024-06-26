package com.example.umcmission.apiPayload.code.status;

import com.example.umcmission.apiPayload.code.BaseErrorCode;
import com.example.umcmission.apiPayload.code.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // For test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER4003", "사용자를 찾을 수 없습니다."),

    // 음식 선호 에러
    FOOD_PREFERENCE_NOT_FOUND(HttpStatus.NOT_FOUND, "PREFERENCE400", "해당 선호를 찾을 수 없습니다."),

    // 미션 에러
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION400", "해당 미션을 찾을 수 없습니다."),

    // 식당 에러
    RESTAURANT_NOT_FOUND(HttpStatus.NOT_FOUND, "RESTAURANT400", "해당 식당을 찾을 수 없습니다."),

    // 지역 에러
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION400", "해당 지역을 찾을 수 없습니다."),

    // 예시,,,
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDto getReason() {
        return ErrorReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return ErrorReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
