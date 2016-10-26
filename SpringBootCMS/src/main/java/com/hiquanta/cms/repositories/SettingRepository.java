package com.hiquanta.cms.repositories;

import com.hiquanta.cms.models.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hiquanta on 2016/10/24.
 */
@Repository
public interface SettingRepository extends JpaRepository<Setting, Long> {
    Setting findByKey(String key);
}
