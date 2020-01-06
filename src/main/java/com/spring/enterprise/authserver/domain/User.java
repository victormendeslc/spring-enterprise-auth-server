package com.spring.enterprise.authserver.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}, name = "USER_UNIQUE_USERNAME"))
public class User extends AbstractEntity implements UserDetails {

    @Column(length = 50)
    private String username;

    @Column
    private String password;

    @Column
    private Boolean accountExpired;

    @Column
    private Boolean accountLocked;

    @Column
    private Boolean credentialsExpired;

    @Column
    private Boolean enabled;

    @Column
    private String activationKey;

    @Column
    private String resetPasswordKey;

    @OneToMany(mappedBy = "user", targetEntity = UserAuthority.class, cascade = {
            CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<UserAuthority> userAuthorities = new HashSet<UserAuthority>();

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
