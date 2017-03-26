package com.toll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toll.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
