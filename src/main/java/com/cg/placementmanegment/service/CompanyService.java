package com.cg.placementmanegment.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.placementmanegment.model.Company;
import com.cg.placementmanegment.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
    private CompanyRepository companyRepository;
	
	public List<Company> listAll() {
        return companyRepository.findAll();
    }
     
    public void save(Company plc) {
    	companyRepository.save(plc);
    }
     
    public Company get(long id) {
        return companyRepository.findById(id).get();
    }
     
    public void delete(long id) {
    	companyRepository.deleteById(id);
    	
    }
   

   
}
