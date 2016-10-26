package com.hiquanta.cms.services;

import java.io.Serializable;

/**
 * Created by hiquanta on 2016/10/23.
 */
public interface SettingService {
    Serializable get(String key);
    Serializable get(String key, Serializable defaultValue);
    void put(String key, Serializable value);
}
