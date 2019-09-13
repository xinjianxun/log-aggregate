package com.aioria.msg.auth;


import com.aioria.constant.RestCodeConstants;
import com.aioria.msg.BaseResponse;

public class TokenErrorResponse extends BaseResponse {
    public TokenErrorResponse(String message) {
        super(RestCodeConstants.TOKEN_ERROR_CODE, message);
    }
}
