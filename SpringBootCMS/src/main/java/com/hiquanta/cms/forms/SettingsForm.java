package com.hiquanta.cms.forms;

import com.hiquanta.cms.models.support.PostFormat;
import com.hiquanta.cms.models.support.PostStatus;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by hiquanta on 2016/10/23.
 */
@Data
public class SettingsForm {
    @NotEmpty
    @NotNull
    private String siteName;

    @NotNull
    private String siteSlogan;

    @NotNull
    private Integer pageSize;
}
