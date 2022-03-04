package com.cg.placementmanegment.service;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.placementmanegment.exception.JobSeekerNotFoundException;
import com.cg.placementmanegment.model.JobSeeker;
import com.cg.placementmanegment.repository.JobSeekerRepository;




@Service
public class JobSeekerServiceImpl implements JobSeekerService {

	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	public JobSeekerServiceImpl() {
		super(); // TODO Auto-generated constructor
	  }
	 
	 public JobSeekerServiceImpl(JobSeekerRepository jobSeekerRepository) {
	  super();
	 this.jobSeekerRepository = jobSeekerRepository; }
	  
	 
	 
	
	@Override
	public List<JobSeeker> findAll() {
		// TODO Auto-generated method stub
		return jobSeekerRepository.findAll(); 
	}

	@Override
	public Optional<JobSeeker> getJobSeekerById(Integer id) {
		// TODO Auto-generated method stub
		return jobSeekerRepository.findById(id);
	}

	@Override
	public JobSeeker save(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return jobSeekerRepository.save(jobSeeker);
	}

	@Override
	public JobSeeker addJobseeker(JobSeeker jobseeker) {
		// TODO Auto-generated method stub
		return jobSeekerRepository.save(jobseeker);
	}

	@Override
	public JobSeeker loginJobSeeker(String username, String password) {
		// TODO Auto-generated method stub
		 List<JobSeeker> jobseekerlist=jobSeekerRepository.findAll();
		  Iterator<JobSeeker> iterator= jobseekerlist.iterator(); 
		  boolean status=false;
		  JobSeeker jobSeeker= null; 
		  while(iterator.hasNext())
		  {
		 jobSeeker=iterator.next(); 
		  if(jobSeeker.getUsername().equals(username)&&jobSeeker.getPassword().equals(password))
		  { 
			  status=true; 
		  break; 
		  } 
		  }
		  if(status)
		  { 
			  return jobSeeker;
		  } 
		  else { 
			  throw new JobSeekerNotFoundException("Invalid JobSeeker UserName.."); 
		  }
		  
		  }
	

	@Override
	public List<JobSeeker> listAll() {
		// TODO Auto-generated method stub
		return jobSeekerRepository.findAll();
	}

	
	
	

	
}
