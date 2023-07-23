package com.jamersondev.eletroshop.domain;

import com.jamersondev.eletroshop.enums.RoleAccess;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "role_access")
@Getter
@Setter
public class Role implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = -2213552921935782199L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "access_role_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleAccess role;

    @Override
    public String getAuthority() {
        return this.role.getRoleDescripton();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
