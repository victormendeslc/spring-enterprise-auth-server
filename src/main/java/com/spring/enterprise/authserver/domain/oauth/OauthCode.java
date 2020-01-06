package com.spring.enterprise.authserver.domain.oauth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

/**
 * create table oauth_code (
 *   code VARCHAR(256),
 *   authentication LONGVARBINARY
 * );
 */
@Entity
@Immutable
@Table(name = "oauth_code")
@Getter
public class OauthCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;

    @Column(name = "code", length = 256)
    String code;
    @Column(name = "authentication")
    Byte[] authentication;
}
