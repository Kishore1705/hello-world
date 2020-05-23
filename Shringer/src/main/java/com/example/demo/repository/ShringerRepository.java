package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Shringer;

public interface ShringerRepository extends CrudRepository<Shringer, Integer>{
	
	
	@Query("Select s from Shringer s  WHERE email=:email")
	public Shringer getByEmail(@Param("email") String email);
	
	@Query("Select s from Shringer s where confirmation_token=:confirmation_token")
	public Shringer getInfoByToken(@Param("confirmation_token") String token);
	
	
	

}
