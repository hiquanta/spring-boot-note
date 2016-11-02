package com.hiquanta.cms.controllers;

import com.hiquanta.cms.Constants;
import com.hiquanta.cms.models.Post;
import com.hiquanta.cms.services.AppSetting;
import com.hiquanta.cms.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;
/**
 * Created by hiquanta on 2016/10/21.
 */
@Controller
public class HomeController {
    @Autowired
    private PostService postService;

    @Autowired
    private AppSetting appSetting;

    @RequestMapping(value = "", method = GET)
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
        page = page < 1 ? 0 : page - 1;
        Page<Post> posts = postService.getAllPublishedPostsByPage(page, appSetting.getPageSize());

        model.addAttribute("totalPages", posts.getTotalPages());
        model.addAttribute("posts", posts);
        model.addAttribute("page", page + 1);
       // model.addAttribute("App", appSetting);

        return "home/index";
    }

    @RequestMapping(value = "about", method = GET)
    public String about(Model model) {
        Post post = postService.getPublishedPostByPermalink(Constants.ABOUT_PAGE_PERMALINK);

        if (post == null) {
            post = postService.createAboutPage();
        }

        model.addAttribute("about", post);
        return "home/about";
    }

}
