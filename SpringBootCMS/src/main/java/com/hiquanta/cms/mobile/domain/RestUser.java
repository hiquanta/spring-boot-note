package com.hiquanta.cms.mobile.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by hiquanta on 2016/10/29.
 */
@Setter
@Getter
public class RestUser implements Serializable {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER  = "ROLE_USER";
    private String email;
    private String role = ROLE_USER;
    private String token;

}
