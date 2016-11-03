package com.hiquanta.cms.controllers;

import com.hiquanta.cms.error.NotFoundException;
import com.hiquanta.cms.models.Post;
import com.hiquanta.cms.services.AppSetting;
import com.hiquanta.cms.services.PostService;
import com.hiquanta.cms.support.web.ViewHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by hiquanta on 2016/10/26.
 */
@Controller
@RequestMapping("posts")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private AppSetting appSetting;
    @Autowired
    private ViewHelper viewHelper;
    @RequestMapping(value = "archive", method = GET)
    public String archive(Model model){
        model.addAttribute("posts", postService.getArchivePosts());

        return "posts/archive";
    }

    @RequestMapping(value = "{permalink}", method = GET)
    public String show(@PathVariable String permalink, Model model){
        Post post = null;

//        try{
//            post = postService.getPublishedPostByPermalink(permalink);
//        } catch (NotFoundException ex){
//            if (permalink.matches("\\d+"))
//                post = postService.getPost(Long.valueOf(permalink));
//        }
//
//        if (post == null)
//            throw new NotFoundException("Post with permalink " + permalink + " is not found");
        model.addAttribute("App", appSetting);
        model.addAttribute("viewHelper", viewHelper);
//        model.addAttribute("post", post);
//        model.addAttribute("tags", postService.getPostTags(post));

        return "posts/show";
    }
}
