package com.hiquanta.cms.error;

/**
 * Created by hiquanta on 2016/10/23.
 */
public class NotFoundException extends RuntimeException {
    private String message;

    public NotFoundException(){

    }

    public NotFoundException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
