package com.spring.enterprise.authserver.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Data
@Entity
@Table(name = "user_authority", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "authority_id"}, name = "USER_AUTHORITY_UNIQUE_USER_ID_AND_AUTHORITY_ID"))
public class UserAuthority extends AbstractEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_AUTHORITY_USER_ID"))
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authority_id", foreignKey = @ForeignKey(name = "FK_USER_AUTHORITY_AUTHORITY_ID"))
    private Authority authority;
}
