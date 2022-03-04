package com.cg.placementmanegment.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.placementmanegment.exception.AdminNotFoundException;
import com.cg.placementmanegment.model.Admin;
import com.cg.placementmanegment.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
  
 
	public AdminService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}
	public Admin login(String username, String password) 
  {
	  List<Admin> adminlist=adminRepository.findAll();
		Iterator<Admin> iterator= adminlist.iterator();
		boolean status=false;
		Admin admin= null;
		while(iterator.hasNext())
		{
			admin=iterator.next();
			if(admin.getUsername().equals(username)&& admin.getPassword().equals(password))
			{
				status=true;
				break;
			}
		}
		if(status)
		{
			return admin;
		}
		else
		{
			throw new AdminNotFoundException("Invalid Admin UserName..");
		}
	
	
	

  }
  public Admin addAdmin(Admin admin) {
		
		// TODO Auto-generated method stub
		return adminRepository.save(admin) ;
	}


}
