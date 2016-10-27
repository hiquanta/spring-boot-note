package com.hiquanta.cms.resetservices.v1;

import com.hiquanta.cms.models.User;
import com.hiquanta.cms.restrepositories.v1.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hiquanta on 2016/10/27.
 */
@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    public User doLogin(){
        return loginRepository.getOne(Long.valueOf(1));
    }
}
