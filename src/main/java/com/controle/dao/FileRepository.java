package com.controle.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.controle.entities.File;

public interface FileRepository extends JpaRepository<File, Long>{
	
	@Query("select f from File f where f.user.machineName = :x")
	public Page<File> getfiles(@Param("x") String machineName, Pageable pageable);
	@Modifying
	@Transactional
	@Query("DELETE from File f where f.user.machineName = :x")
	public void deletefiles(@Param("x") String machineName);


}
