package com.toll.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toll.domain.RfId;

@Repository
public interface RfIdRepository extends JpaRepository<RfId, Long> {
    
	@Query(value = "select r from RfId r inner join r.vehical v where (lower(v.vehicalNo) like ?1)")
	public Page<RfId> findByVehicalNoLikeIgnoreCase(String search, org.springframework.data.domain.Pageable pageable);
	
}
