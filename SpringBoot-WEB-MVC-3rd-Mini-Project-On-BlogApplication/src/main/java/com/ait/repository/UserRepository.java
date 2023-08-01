package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entityclasses.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	public UserDetails findByemail(String email);

	public UserDetails findByemailAndPassword(String email, String password);

	
}
