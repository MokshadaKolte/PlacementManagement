package com.cg.placementmanegment.service;

import java.util.List;
import java.util.Optional;

import com.cg.placementmanegment.model.JobSeeker;






public interface JobSeekerService {

	List<JobSeeker> findAll();

	Optional<JobSeeker> getJobSeekerById(Integer id);

	JobSeeker save(JobSeeker jobSeeker);
	public JobSeeker addJobseeker(JobSeeker jobseeker);

	JobSeeker loginJobSeeker(String username, String password);

	List<JobSeeker> listAll();
}
