package com.example.umcmission.apiPayload.exception.handler;

import com.example.umcmission.apiPayload.code.BaseErrorCode;
import com.example.umcmission.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode code) {
        super(code);
    }
}
