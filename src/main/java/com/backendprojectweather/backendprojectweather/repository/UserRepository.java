package com.backendprojectweather.backendprojectweather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backendprojectweather.backendprojectweather.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	
	@Query(value = "SELECT * FROM USER WHERE EMAIL=?1 LIMIT 1",nativeQuery = true)
	public User findByEmail(String email);
}
