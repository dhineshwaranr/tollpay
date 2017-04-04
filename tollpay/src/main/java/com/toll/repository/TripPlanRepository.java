package com.toll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toll.domain.TripPlan;
import com.toll.domain.User;

@Repository
public interface TripPlanRepository extends JpaRepository<TripPlan, Long> {

	public TripPlan findByUser(User user);
	
}
