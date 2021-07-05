package com.devsuperior.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.learn.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
