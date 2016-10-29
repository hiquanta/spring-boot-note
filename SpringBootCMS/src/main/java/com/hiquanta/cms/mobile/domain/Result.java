package com.hiquanta.cms.mobile.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hiquanta on 2016/10/29.
 */
@Getter
@Setter
public class Result {

    private int errorCode;


    private String errorMessage;

    public Result() {
    }

    public Result(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public boolean OK() {
        return errorCode == 0;
    }


}
