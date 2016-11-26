package com.controle.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.controle.entities.File;
import com.controle.entities.Keylogger;

public interface KeyloggerRepository extends JpaRepository<Keylogger, Long> {
	@Query("select k from Keylogger k where k.user.machineName = :x")
	public Page<Keylogger> getKeyloggers(@Param("x") String machineName, Pageable pageable);
	@Modifying
	@Transactional
	@Query("DELETE from Keylogger k where k.user.machineName = :x")
	public void deleteKeyloggers(@Param("x") String machineName);
}
