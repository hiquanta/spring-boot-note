package com.hiquanta.cms.utils;

import com.hiquanta.cms.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hiquanta on 2016/10/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GsonUtilsTest {

    @Test
    public void GsonTest() throws Exception{
        User user=new User("123@123.com","admin","admin");
      String str=      GsonUtils.toJsonString(user);
        System.out.println(str+"");
    }

}
