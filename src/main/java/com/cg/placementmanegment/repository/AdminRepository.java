package com.cg.placementmanegment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.placementmanegment.model.Admin;



@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
	Admin findByUsernameAndPassword(String username, String password);

}


