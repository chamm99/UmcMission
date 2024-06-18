package com.example.umcmission.apiPayload.exception.handler;

import com.example.umcmission.apiPayload.code.BaseErrorCode;
import com.example.umcmission.apiPayload.exception.GeneralException;

public class UserHandler extends GeneralException {
    public UserHandler(BaseErrorCode code) {
        super(code);
    }
}
