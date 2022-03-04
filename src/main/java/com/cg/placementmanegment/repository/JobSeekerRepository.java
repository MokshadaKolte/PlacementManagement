package com.cg.placementmanegment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.placementmanegment.model.JobSeeker;



public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

	JobSeeker findByUsernameAndPassword(String username, String password);

}
