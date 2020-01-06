package com.spring.enterprise.authserver.domain.oauth;

import lombok.Getter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * create table oauth_client_details (
 *   client_id VARCHAR(256) PRIMARY KEY,
 *   resource_ids VARCHAR(256),
 *   client_secret VARCHAR(256),
 *   scope VARCHAR(256),
 *   authorized_grant_types VARCHAR(256),
 *   web_server_redirect_uri VARCHAR(256),
 *   authorities VARCHAR(256),
 *   access_token_validity INTEGER,
 *   refresh_token_validity INTEGER,
 *   additional_information VARCHAR(4096),
 *   autoapprove VARCHAR(256)
 * );
 */
@Entity
@Immutable
@Table(name = "oauth_client_details")
@Getter
public class OauthClientDetails {

    @Id
    @Column(name = "client_id", length = 256)
    String clientId;
    @Column(name = "resource_ids", length = 256)
    String resourceIds;
    @Column(name = "client_secret", length = 256)
    String clientSecret;
    @Column(name = "scope", length = 256)
    String scope;
    @Column(name = "authorized_grant_types", length = 256)
    String authorizedGrantTypes;
    @Column(name = "web_server_redirect_uri", length = 256)
    String webServerRedirectUri;
    @Column(name = "authorities", length = 256)
    String authorities;
    @Column(name = "access_token_validity")
    Long accessTokenValidity;
    @Column(name = "refresh_token_validity")
    Long refreshTokenValidity;
    @Column(name = "additional_information", length = 4096)
    String additionalInformation;
    @Column(name = "autoapprove", length = 256)
    String autoapprove;
}
