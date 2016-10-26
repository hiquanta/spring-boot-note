package com.hiquanta.cms.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by hiquanta on 2016/10/23.
 */
@Data
public class UserForm {
    @NotNull
    private String password;

    @NotNull
    private String newPassword;
}
