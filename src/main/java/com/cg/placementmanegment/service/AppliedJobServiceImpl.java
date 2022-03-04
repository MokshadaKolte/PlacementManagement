package com.cg.placementmanegment.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.placementmanegment.model.AppliedJob;
import com.cg.placementmanegment.repository.AppliedJobRepository;
@Service
public class AppliedJobServiceImpl implements AppliedJobService {

	@Autowired
	private AppliedJobRepository appliedJobRepository;

	@Override
	public void save(AppliedJob appliedJob) {
		// TODO Auto-generated method stub
		appliedJobRepository.save(appliedJob);	
	}

	@Override
	public List<AppliedJob> findAll() {
		// TODO Auto-generated method stub
		return appliedJobRepository.findAll(); 
	}

	@Override
	public List<AppliedJob> findByJobSeekerId(Integer jobseekerId) {
		// TODO Auto-generated method stub
		List<AppliedJob> appliedJobList=
				  appliedJobRepository.findAll();
		Iterator<AppliedJob> iterator=appliedJobList.iterator(); 
				  List<AppliedJob> appliedJobSeekerList= new ArrayList(); 
				  AppliedJob appliedJob= null; 
				  while(iterator.hasNext()) {
				  appliedJob=iterator.next(); 
				  if(appliedJob.getJobSeeker().getUserid()==jobseekerId)
				  { 
					  appliedJobSeekerList.add(appliedJob); 
				  }
				  
				  } 
				  return appliedJobSeekerList; 
				  }
	
	
}


