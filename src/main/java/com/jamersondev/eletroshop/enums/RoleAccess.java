package com.jamersondev.eletroshop.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RoleAccess {
    ROLE_USER("User"),
    ROLE_ADMIN("Administrador");

    @JsonValue
    private String roleDescripton;

    RoleAccess(String roleDescripton) {
        this.roleDescripton = roleDescripton;
    }

    public String getRoleDescripton() {
        return roleDescripton;
    }

    public void setRoleDescripton(String roleDescripton) {
        this.roleDescripton = roleDescripton;
    }
}
