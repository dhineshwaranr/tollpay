package com.toll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toll.domain.RTO;

@Repository
public interface RTORepository extends JpaRepository<RTO, Long>{

	
	
}
