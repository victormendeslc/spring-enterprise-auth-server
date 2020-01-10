package com.spring.enterprise.authserver.commons;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private String uuid;
    private String username;
    private String password;
    private Boolean accountExpired;
    private Boolean accountLocked;
    private Boolean credentialsExpired;
    private Boolean enabled;
    private String activationKey;
    private String resetPasswordKey;
}
