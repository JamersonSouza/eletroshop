package com.jamersondev.eletroshop;

import com.jamersondev.eletroshop.domain.Role;
import com.jamersondev.eletroshop.enums.RoleAccess;
import com.jamersondev.eletroshop.repository.RoleRepository;
import com.jamersondev.eletroshop.service.RoleService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTests extends TestCase {
    @Autowired
    private RoleService roleService;


    @Test
    void registrationAccessTest(){
        Role role = new Role();
        role.setRole(RoleAccess.ROLE_ADMIN);
        roleService.rolePersistence(role);

        assertTrue(role.getId() > 1);
        assertEquals(RoleAccess.ROLE_ADMIN, role.getRole());
    }

}
