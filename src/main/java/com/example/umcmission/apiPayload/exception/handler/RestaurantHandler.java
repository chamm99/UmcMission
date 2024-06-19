package com.example.umcmission.apiPayload.exception.handler;

import com.example.umcmission.apiPayload.code.BaseErrorCode;
import com.example.umcmission.apiPayload.exception.GeneralException;

public class RestaurantHandler extends GeneralException {
    public RestaurantHandler(BaseErrorCode code) {
        super(code);
    }
}
