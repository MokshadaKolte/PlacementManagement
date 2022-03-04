package com.cg.placementmanegment.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.placementmanegment.exception.RecruiterNotFoundException;
import com.cg.placementmanegment.model.JobSeeker;
import com.cg.placementmanegment.model.Recruiter;
import com.cg.placementmanegment.repository.JobSeekerRepository;
import com.cg.placementmanegment.repository.RecruiterRepository;

@Service
public class RecruiterServiceImpl implements RecruiterService{

	@Autowired
	private RecruiterRepository recruiterRepository;
	
	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	@Override
	public List<Recruiter> findAll() {
		// TODO Auto-generated method stub
		return recruiterRepository.findAll();
	}

	@Override
	public Optional<Recruiter> getRecruiterById(Long id) {
		// TODO Auto-generated method stub
		return recruiterRepository.findById(id);
	}
	@Override
	public Recruiter addRecruiter(Recruiter recruiter) {
		// TODO Auto-generated method stub
		return recruiterRepository.save(recruiter);
	}

	
	@Override
	public Recruiter loginRecruiter(String username, String password) {
		// TODO Auto-generated method stub
		List<Recruiter> recruiterlist=recruiterRepository.findAll();
		Iterator<Recruiter> iterator= recruiterlist.iterator();
		boolean status=false;
		Recruiter recruiter= null;
		while(iterator.hasNext())
		{
			recruiter=iterator.next();
			if(recruiter.getUsername().equals(username)&& recruiter.getPassword().equals(password))
			{
				status=true;
				break;
			}
		}
		if(status)
		{
			return recruiter;
		}
		else
		{
			throw new RecruiterNotFoundException("Invalid Recruiter UserName..");
		}
	
	}
	@Override
	public JobSeeker verifyJobSeeker(Long recruiterId, Integer jobseekerId) {
		// TODO Auto-generated method stub
		Recruiter recruiter = recruiterRepository.findById(recruiterId).get();
		JobSeeker jobSeeker = jobSeekerRepository.findById(jobseekerId).get();
		if(recruiter.getUsername().equals("wipro"))
		{
		     if(jobSeeker.getPassoutyear().equals("2020")&& jobSeeker.getEducation().equals("BE"))
		     {
		    	 jobSeeker.setInterview_status("Interview Scheduled");
		    	 jobSeekerRepository.save(jobSeeker);
		    	 System.out.println("Interview Scheduled");
		     }
		     else
		     {
		    	 jobSeeker.setInterview_status("Application Rejected");
		    	 jobSeekerRepository.save(jobSeeker);
		    	 System.out.println("Application Rejected");
				    
		    
		     }
		     
		}
		else if(recruiter.getUsername().equals("Infosys"))
				{
		     if(jobSeeker.getPassoutyear().equals("2021")&& jobSeeker.getEducation().equals("MBA"))
		     {
		    	 jobSeeker.setInterview_status("Interview Scheduled");
		    	 jobSeekerRepository.save(jobSeeker);
		    	 System.out.println("Interview Scheduled");
				 
		     }
		     else
		     {
		    	 jobSeeker.setInterview_status("Application Rejected");
		    	 jobSeekerRepository.save(jobSeeker);
		    	 System.out.println("Application Rejected");
				 
		    
		     }
		    
		}
		else if(recruiter.getUsername().equals("Accenture"))
				{
		     if(jobSeeker.getPassoutyear().equals("2019"))
		     {
		    	 String [] skills=jobSeeker.getSkills().split(",");
		    	 for(int i=0;i<skills.length;i++)
		    	 {
		    		 if(skills[i].equals("Java Programming"))
		    		 {
		    			 jobSeeker.setInterview_status("Interview Scheduled");
				    	 jobSeekerRepository.save(jobSeeker);
				    	
		    		 }
		    		 else if(skills[i].equals("c"))
		    		 {
		    			 jobSeeker.setInterview_status("Interview Scheduled");
				    	 jobSeekerRepository.save(jobSeeker);
				    	 
				    	 
		    		 }
		    		 else if(skills[i].equals("c++"))
		    		 {
		    			 jobSeeker.setInterview_status("Interview Scheduled");
				    	 jobSeekerRepository.save(jobSeeker);
				    	 
		    		 } 		 
		    			 
		    	 }
		     }
		     else
		     {
		    	 jobSeeker.setInterview_status("Application Rejected");
		    	 jobSeekerRepository.save(jobSeeker);
		    
		     }
		    
		}
		else
		{
			 jobSeeker.setInterview_status("Interview Scheduled");
	    	 jobSeekerRepository.save(jobSeeker);
	    	 System.out.println("Interview Scheduled");
			 
	    
		  
		}
		
		
		return jobSeeker;
	}


	

	

	
	}

	
	
	
	


