package com.controle.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controle.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, String>{

}
