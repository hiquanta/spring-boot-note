package com.hiquanta.cms.resetservices.v1;

import com.hiquanta.cms.models.User;
import com.hiquanta.cms.restrepositories.v1.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by hiquanta on 2016/10/27.
 */
@Service
public class LoginService {
    @Inject
    private PasswordEncoder passwordEncoder;
    @Autowired
    private LoginRepository loginRepository;
    public User doLogin(String username,String password){
       // return loginRepository.getOne(Long.valueOf(1));
       // return loginRepository.findByEmail(username);
      String encodepassword=  passwordEncoder.encode(password);
      // return loginRepository.findByEmailAndRole(username,"ROLE_ADMIN");
      return loginRepository.findByEmailAndPassword("admin@admin.com",password);

    }

}
