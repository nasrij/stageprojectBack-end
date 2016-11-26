package com.controle.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.controle.entities.Process;

public interface ProcessRepository extends JpaRepository<com.controle.entities.Process, Long> {
	@Query("select p from Process p where p.user.machineName = :x")
	public Page<Process> getProcess(@Param("x") String machineName, Pageable pageable);
	@Modifying
	@Transactional
	@Query("DELETE from Process p where p.user.machineName = :x")
	public void deleteProcess(@Param("x") String machineName);
}
