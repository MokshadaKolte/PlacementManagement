package com.cg.placementmanegment.service;

import java.util.List;

import com.cg.placementmanegment.model.AppliedJob;

public interface AppliedJobService {

	public void save(AppliedJob appliedJob);
	List<AppliedJob> findAll();
	public List<AppliedJob> findByJobSeekerId(Integer jobseekerId);
	
}
