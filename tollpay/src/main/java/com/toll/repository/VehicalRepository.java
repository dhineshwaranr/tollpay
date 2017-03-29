package com.toll.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toll.domain.Vehical;

@Repository
public interface VehicalRepository extends JpaRepository<Vehical, Long> {

	//@Query(value = "select v from Vehical v where (lower(v.vehicalNo) like ?1 DESC")
    Vehical findByVehicalNoLikeIgnoreCase(String searchTerm);
	
}
