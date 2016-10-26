package com.hiquanta.cms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

/**
 * Created by hiquanta on 2016/10/26.
 */
@Controller
public class UserController {
    @RequestMapping("signin")
    public String signin(Principal principal, RedirectAttributes ra) {
        return principal == null ? "users/signin" : "redirect:/";
    }
}
