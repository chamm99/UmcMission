package com.example.umcmission.apiPayload.exception.handler;

import com.example.umcmission.apiPayload.code.BaseErrorCode;
import com.example.umcmission.apiPayload.exception.GeneralException;

public class FoodPreferenceHandler extends GeneralException {
    public FoodPreferenceHandler(BaseErrorCode code) {
        super(code);
    }
}
