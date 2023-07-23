package com.jamersondev.eletroshop.service;

import com.jamersondev.eletroshop.domain.Role;
import com.jamersondev.eletroshop.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role rolePersistence(Role role){
        return roleRepository.save(role);
    }
}
