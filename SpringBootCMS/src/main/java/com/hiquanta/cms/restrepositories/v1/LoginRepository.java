package com.hiquanta.cms.restrepositories.v1;

import com.hiquanta.cms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hiquanta on 2016/10/27.
 */
@Repository
public interface LoginRepository extends JpaRepository<User,Long> {

}
