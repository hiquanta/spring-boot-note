package com.hiquanta.cms.controllers;

import com.hiquanta.cms.error.NotFoundException;
import com.hiquanta.cms.models.Post;
import com.hiquanta.cms.models.Tag;
import com.hiquanta.cms.services.AppSetting;
import com.hiquanta.cms.services.PostService;
import com.hiquanta.cms.services.TagService;
import com.hiquanta.cms.support.web.ViewHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by hiquanta on 2016/10/26.
 */
@Controller
@RequestMapping("tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @Autowired
    private PostService postService;

    @Autowired
    private AppSetting appSetting;
    @Autowired
    private ViewHelper viewHelper;

    @RequestMapping(value = "", method = GET)
    public String index(Model model){
        model.addAttribute("tags", postService.countPostsByTags());
        model.addAttribute("App", appSetting);
        model.addAttribute("viewHelper", viewHelper);
        return "tags/index";
    }

    @RequestMapping(value = "{tagName}", method = GET)
    public String showTag(@PathVariable String tagName, @RequestParam(defaultValue = "1") int page, Model model) {
        Tag tag = tagService.getTag(tagName);

        if (tag == null) {
            throw new NotFoundException("Tag " + tagName + " is not found.");
        }

        page = page < 1 ? 0 : page - 1;
        Page<Post> posts = postService.findPostsByTag(tagName, page, appSetting.getPageSize());

        model.addAttribute("tag", tag);
        model.addAttribute("posts", posts);
        model.addAttribute("page", page + 1);
        model.addAttribute("totalPages", posts.getTotalPages());
        model.addAttribute("App", appSetting);
        model.addAttribute("viewHelper", viewHelper);

        return "tags/show";
    }
}
