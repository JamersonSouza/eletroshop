package com.jamersondev.eletroshop.enums;

public enum RoleAccess {
    ROLE_USER("User"),
    ROLE_ADMIN("Administrador");

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
