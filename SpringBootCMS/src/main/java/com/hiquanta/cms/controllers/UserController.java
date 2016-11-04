package com.hiquanta.cms.controllers;

import com.hiquanta.cms.services.AppSetting;
import com.hiquanta.cms.support.web.ViewHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

/**
 * Created by hiquanta on 2016/10/26.
 */
@Controller
public class UserController {
    @Autowired
    private AppSetting appSetting;
    @Autowired
    private ViewHelper viewHelper;
    @RequestMapping("signin")
    public String signin(Principal principal, RedirectAttributes ra,Model model) {
        model.addAttribute("App", appSetting);
        model.addAttribute("viewHelper", viewHelper);
        return principal == null ? "users/signin" : "redirect:/";
    }
}
