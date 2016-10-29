package com.hiquanta.cms.restcontroller.v1;

import com.hiquanta.cms.mobile.domain.ModelPost;
import com.hiquanta.cms.models.Post;
import com.hiquanta.cms.repositories.UserRepository;
import com.hiquanta.cms.resetservices.v1.PostService;
import com.hiquanta.cms.utils.DTOUtil;
import com.hiquanta.cms.utils.GsonUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hiquanta on 2016/10/29.
 */
@RestController("PostController.v1")
@RequestMapping(value = "v1/posts")
public class PostController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostService postService;
    @ApiOperation(value="得到用户文章列表", notes="")
    @RequestMapping(value = "",method = RequestMethod.POST)

    public String getPost(@RequestParam()String email,@RequestHeader String userAgent){
     //   userRepository.findByToken(userAgent);
       List<Post> posts= postService.findByUser(email);
      List<ModelPost> postList=  DTOUtil.mapList(posts, ModelPost.class);
        return GsonUtils.toJsonString(postList);
    }
    @RequestMapping(value = "/detail",method = RequestMethod.POST)
    @ApiOperation(value="文章详情", notes="")
    public String getDetail(){
        return "文章详情";
    }
}
