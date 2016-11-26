package com.controle.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.controle.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
	
	@Query("select s from Session s where s.user.machineName = :x")
	public Page<Session> getSession(@Param("x") String machineName, Pageable pageable);
	
	@Query("select s from Session s where s.user.machineName = :x order by s.date DESC")
	public List<Session> getLastSession(@Param("x") String machineName);
	
	@Transactional
	@Query("DELETE from Session s where s.user.machineName = :x")
	public void deleteSession(@Param("x") String machineName);

}
