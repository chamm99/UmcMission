package com.example.umcmission.apiPayload.exception.handler;

import com.example.umcmission.apiPayload.code.BaseErrorCode;
import com.example.umcmission.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
