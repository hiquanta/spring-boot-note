package com.hiquanta.cms.resetservices.v1;

import com.hiquanta.cms.models.Post;
import com.hiquanta.cms.models.User;
import com.hiquanta.cms.repositories.PostRepository;
import com.hiquanta.cms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hiquanta on 2016/10/29.
 */
@Service("PostService.v1")
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    public List<Post> findByUser(String email){
       User user= userRepository.findByEmail(email);
     return    postRepository.findByUser(user);
    }
}
