package com.hiquanta.cms.repositories;

import com.hiquanta.cms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hiquanta on 2016/10/24.
 */
public interface UserRepository extends JpaRepository<User,Long>{
    User findByEmail(String email);
}
