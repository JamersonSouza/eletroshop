package com.jamersondev.eletroshop.service;

import com.jamersondev.eletroshop.domain.Role;
import com.jamersondev.eletroshop.repository.RoleRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role rolePersistence(Role role){
        return roleRepository.save(role);
    }

    public Role findRole(Long id){
        Optional<Role> roles = this.roleRepository.findById(id);
        return roles.orElseThrow( () -> new ObjectNotFoundException(id, "no id found"));
    }
}
