package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hiquanta on 2016/10/18.
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "https://www.baidu.com");
        return "index2";
    }
}
