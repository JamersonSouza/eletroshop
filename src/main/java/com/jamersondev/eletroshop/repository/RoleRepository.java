package com.jamersondev.eletroshop.repository;

import com.jamersondev.eletroshop.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {

}
