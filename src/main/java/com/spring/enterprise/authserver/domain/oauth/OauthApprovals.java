package com.spring.enterprise.authserver.domain.oauth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * create table oauth_approvals (
 * 	userId VARCHAR(256),
 * 	clientId VARCHAR(256),
 * 	scope VARCHAR(256),
 * 	status VARCHAR(10),
 * 	expiresAt TIMESTAMP,
 * 	lastModifiedAt TIMESTAMP
 * );
 */
@Entity
@Immutable
@Table(name = "oauth_approvals")
@Getter
public class OauthApprovals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;

    @Column(name = "userId", length = 256)
    String userId;
    @Column(name = "clientId", length = 256)
    String clientId;
    @Column(name = "scope", length = 256)
    String scope;
    @Column(name = "status", length = 10)
    String status;
    @Column(name = "expiresAt")
    Timestamp expiresAt;
    @Column(name = "lastModifiedAt")
    Timestamp lastModifiedAt;

}
