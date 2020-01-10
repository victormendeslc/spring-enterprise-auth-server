package com.spring.enterprise.authserver.commons;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResetPasswordDTO implements Serializable {

    private String username;
    private String oldPassword;
    private String newPassword;
}
