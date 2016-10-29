package com.hiquanta.cms.restcontroller.v1;

import com.hiquanta.cms.mobile.domain.RestUser;
import com.hiquanta.cms.mobile.domain.Result;
import com.hiquanta.cms.mobile.domain.response.LoginBean;
import com.hiquanta.cms.models.User;
import com.hiquanta.cms.resetservices.v1.LoginService;
import com.hiquanta.cms.utils.DTOUtil;
import com.hiquanta.cms.utils.GsonUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by hiquanta on 2016/10/27.
 */
@RestController
@RequestMapping(value = "v1/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
     private LoginBean loginBean=new LoginBean();

    @ApiOperation(value="登录接口", notes="这是手机端登陆接口")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String doLogin(@RequestParam() String username, @RequestParam() String password ) {
    User user= loginService.doLogin(username,password);
        Result result=null;
        if(user==null){
            result=new Result(-1,"用户名或密码错误");
            loginBean.setResult(result);
            return GsonUtils.toJsonString(loginBean);
        }
        user.setToken(new Date().toString());
        loginService.update(user);

        RestUser restUser=  DTOUtil.map(user,RestUser.class);
        result=new Result(0,"登录成功");
        loginBean.setResult(result);
        loginBean.setRestUser(restUser);
        String jsonStr=GsonUtils.toJsonString(loginBean);
        return jsonStr;
    }

}
