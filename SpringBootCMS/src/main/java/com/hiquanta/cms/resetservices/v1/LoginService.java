package com.hiquanta.cms.resetservices.v1;

import com.hiquanta.cms.models.User;
import com.hiquanta.cms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
/**
 * Created by hiquanta on 2016/10/27.
 */
@Service
public class LoginService {
    @Inject
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public User doLogin(String username, String password) {
        User user = userRepository.findByEmail(username);

        boolean isAuth = false;
        if (user != null) {
            isAuth = passwordEncoder.matches(password, user.getPassword());
        }
        if (isAuth) {
            return user;
        } else {
            return null;
        }

    }
    public User update(User user){
        return userRepository.save(user);
    }


}
