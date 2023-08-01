package com.jamersondev.eletroshop.controller;

import com.jamersondev.eletroshop.domain.Role;
import com.jamersondev.eletroshop.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class AccessController {

    private final RoleService roleService;

    public AccessController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/save")
    public ResponseEntity<Role> saveAccess(@RequestBody Role role){
        Role roleSave = this.roleService.rolePersistence(role);
        return new ResponseEntity<Role>(roleSave, HttpStatus.CREATED);
    }
}
