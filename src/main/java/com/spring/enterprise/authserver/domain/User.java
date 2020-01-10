package com.spring.enterprise.authserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}, name = "USER_UNIQUE_USERNAME"))
public class User extends AbstractEntity implements UserDetails {

    @NonNull
    @Column(length = 50)
    private String username;

    @NonNull
    @Column
    private String password;

    @NonNull
    @Column(name = "account_expired")
    private Boolean accountExpired;

    @NonNull
    @Column(name="account_locked")
    private Boolean accountLocked;

    @NonNull
    @Column(name="credentials_expired")
    private Boolean credentialsExpired;

    @NonNull
    @Column
    private Boolean enabled;

    @Column(name = "activation_key")
    private String activationKey;

    @Column(name = "reset_password_key")
    private String resetPasswordKey;

    @OneToMany(mappedBy = "user", targetEntity = UserAuthority.class, cascade = {
            CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserAuthority> userAuthorities = new HashSet<>();

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        userAuthorities.forEach(userAuthority -> {
            authorities.add(new SimpleGrantedAuthority(userAuthority.getAuthority().getName()));
        });

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !accountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
