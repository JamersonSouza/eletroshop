package com.jamersondev.eletroshop.repository;

import com.jamersondev.eletroshop.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "SELECT a FROM role_access a WHERE UPPER(TRIM(a.access_role_type)) LIKE %?1%", nativeQuery = true)
    List<Role> findRoleAccess(String desc);

}
