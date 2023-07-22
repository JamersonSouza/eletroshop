package com.jamersondev.eletroshop.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserSystem implements Serializable, UserDetails {

    private static final long serialVersionUID = 2082240691950397494L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String login;

    private String password;

    @Temporal(TemporalType.DATE)
    private Date currentDatePassword;

    @OneToMany(fetch = FetchType.LAZY)
    /*União de tabela de User com Role_Access para gerar uma nova tabela -> users_access */
    @JoinTable(name = "users_access", uniqueConstraints = @UniqueConstraint(columnNames = {
            "user_id", "role_access_id"
    }, name = "unique_role_access_user"), joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id",
    table = "user", unique = false, foreignKey = @ForeignKey(name = "user_fk", value = ConstraintMode.CONSTRAINT))
    , inverseJoinColumns = @JoinColumn(name = "role_access_id", unique = false, referencedColumnName = "id", table = "role_access",
    foreignKey = @ForeignKey(name = "role_access_id", value = ConstraintMode.CONSTRAINT)))
    private List<Role> roleAccess;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roleAccess;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
