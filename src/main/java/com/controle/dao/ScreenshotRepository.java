package com.controle.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.controle.entities.Process;
import com.controle.entities.Screenshot;

public interface ScreenshotRepository extends JpaRepository<Screenshot, Long> {
	@Query("select s from Screenshot s where s.user.machineName = :x")
	public Page<Screenshot> getScreenshots(@Param("x") String machineName, Pageable pageable);
	@Modifying
	@Transactional
	@Query("DELETE from Screenshot s where s.user.machineName = :x")
	public void deleteScreenshots(@Param("x") String machineName);
}
