package com.hiquanta.cms.mobile.domain.response;

import com.hiquanta.cms.mobile.domain.RestUser;
import com.hiquanta.cms.mobile.domain.Result;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by hiquanta on 2016/10/29.
 */
@Getter
@Setter
public class LoginBean {

    private Result result;
    private RestUser restUser;
}
