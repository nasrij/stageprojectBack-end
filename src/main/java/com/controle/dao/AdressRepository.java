package com.controle.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.controle.entities.Adress;
import com.controle.entities.File;

public interface AdressRepository extends JpaRepository<Adress, Long> {
	
	@Query("select a from Adress a where a.user.machineName = :x")
	public Page<Adress> getAdress(@Param("x") String machineName, Pageable pageable);
	
	@Query("select a from Adress a where a.user.machineName = :x order by a.date DESC")
	public List<Adress> getLastAdress(@Param("x") String machineName);
	
	@Transactional
	@Query("DELETE from Adress a where a.user.machineName = :x")
	public void deleteAdress(@Param("x") String machineName);
	

}
