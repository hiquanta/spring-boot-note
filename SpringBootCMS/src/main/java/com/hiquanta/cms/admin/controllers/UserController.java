package com.hiquanta.cms.admin.controllers;

import com.hiquanta.cms.forms.UserForm;
import com.hiquanta.cms.models.User;
import com.hiquanta.cms.repositories.UserRepository;
import com.hiquanta.cms.services.AppSetting;
import com.hiquanta.cms.services.UserService;
import com.hiquanta.cms.support.web.MessageHelper;
import com.hiquanta.cms.support.web.ViewHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by hiquanta on 2016/10/26.
 */
@Controller("adminUserController")
@RequestMapping("admin/users")
public class UserController {
    private UserService userService;
    private UserRepository userRepository;
    @Autowired
    private AppSetting appSetting;
    @Autowired
    private ViewHelper viewHelper;
    @Autowired
    public UserController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping("profile")
    public String profile(Model model){
        model.addAttribute("user", userService.currentUser());
        model.addAttribute("App", appSetting);
        model.addAttribute("viewHelper", viewHelper);
        return "admin/users/profile";
    }

    @RequestMapping(value = "{userId:[0-9]+}", method = POST)
    public String update(@PathVariable Long userId, @Valid UserForm userForm, Errors errors, Model model,RedirectAttributes ra){
        User user = userRepository.findOne(userId);
        model.addAttribute("App", appSetting);
        model.addAttribute("viewHelper", viewHelper);
        Assert.notNull(user);

        if (errors.hasErrors()){
            // do something

            return "admin/users/profile";
        }

        if (!userForm.getNewPassword().isEmpty()){

            if (!userService.changePassword(user, userForm.getPassword(), userForm.getNewPassword()))
                MessageHelper.addErrorAttribute(ra, "Change password failed.");
            else
                MessageHelper.addSuccessAttribute(ra, "Change password successfully.");

        }

        return "redirect:profile";
    }
}
