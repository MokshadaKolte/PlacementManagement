package com.cg.placementmanegment.service;

import java.util.List;
import java.util.Optional;

import com.cg.placementmanegment.model.JobSeeker;
import com.cg.placementmanegment.model.Recruiter;

public interface RecruiterService {
	
	List<Recruiter> findAll();

	Optional<Recruiter> getRecruiterById(Long id);

	public JobSeeker verifyJobSeeker(Long recruiterId,Integer jobseekerId);
	
	public Recruiter addRecruiter(Recruiter recruiter);

	Recruiter loginRecruiter(String username, String password);
	

	}
