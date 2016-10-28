package com.hiquanta.cms.restcontroller.v1;

import com.hiquanta.cms.models.User;
import com.hiquanta.cms.resetservices.v1.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hiquanta on 2016/10/27.
 */
@RestController
@RequestMapping(value = "v1/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @ApiOperation(value="登录接口", notes="notes")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String doLogin(@RequestParam() String username, @RequestParam() String password ) {
    User user= loginService.doLogin(username,password);
        if(user==null){
            return "no value";
        }
        return user.getEmail();
    }
}
