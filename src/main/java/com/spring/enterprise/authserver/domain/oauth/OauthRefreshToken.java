package com.spring.enterprise.authserver.domain.oauth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

/**
 * create table oauth_refresh_token (
 * token_id VARCHAR(256),
 * token LONGVARBINARY,
 * authentication LONGVARBINARY
 * );
 */
@Entity
@Immutable
@Table(name = "oauth_refresh_token")
@Getter
public class OauthRefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;

    @Column(name = "token_id", length = 256)
    String tokenId;
    @Column(name = "token")
    Byte[] token;
    @Column(name = "authentication")
    Byte[] authentication;
}
