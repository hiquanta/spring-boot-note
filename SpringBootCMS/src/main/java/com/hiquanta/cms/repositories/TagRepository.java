package com.hiquanta.cms.repositories;

import com.hiquanta.cms.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hiquanta on 2016/10/24.
 */
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);
}
