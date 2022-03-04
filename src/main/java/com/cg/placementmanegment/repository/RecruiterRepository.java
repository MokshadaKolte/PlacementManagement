package com.cg.placementmanegment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.placementmanegment.model.Recruiter;



public interface RecruiterRepository extends JpaRepository<Recruiter,Long>{

	Recruiter findByUsernameAndPassword(String username, String password);

}
