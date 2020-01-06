package com.spring.enterprise.authserver.domain.oauth;

import lombok.Getter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

/**
 * create table oauth_client_token (
 *   authentication_id VARCHAR(256) PRIMARY KEY,
 *   token_id VARCHAR(256),
 *   token LONGVARBINARY,
 *   user_name VARCHAR(256),
 *   client_id VARCHAR(256)
 * );
 */
@Entity
@Immutable
@Table(name = "oauth_client_token")
@Getter
public class OauthClientToken {

    @Id
    @Column(name = "authentication_id", length = 256)
    String authenticationId;
    @Column(name = "token_id", length = 256)
    String tokenId;
    @Column(name = "token")
    Byte[] token;
    @Column(name = "user_name", length = 256)
    String userName;
    @Column(name = "client_id", length = 256)
    String clientId;
}
