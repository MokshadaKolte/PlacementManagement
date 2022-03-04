package com.cg.placementmanegment.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PlacementTable")

public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
    private String companyname;
    private String companylocation;
    private String companyemail;
    private String qualification_required;
    private String role;
    private String skills;
    private LocalDate posteddate = LocalDate.now(ZoneId.of("GMT+05:30"));

     private String salary;
     
     @OneToMany(mappedBy="company")
   
     List<AppliedJob> appliedJob;
     
	public List<AppliedJob> getAppliedJob() {
		return appliedJob;
	}

	public void setAppliedJob(List<AppliedJob> appliedJob) {
		this.appliedJob = appliedJob;
	}

	public Company() {
		
		// TODO Auto-generated constructor stub
	}

	public Company(Long id, String companyname, String companylocation, String companyemail,
			String qualification_required, String role, String skills, LocalDate posteddate, String salary,
			List<AppliedJob> appliedJob) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.companylocation = companylocation;
		this.companyemail = companyemail;
		this.qualification_required = qualification_required;
		this.role = role;
		this.skills = skills;
		this.posteddate = posteddate;
		this.salary = salary;
		this.appliedJob = appliedJob;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanylocation() {
		return companylocation;
	}

	public void setCompanylocation(String companylocation) {
		this.companylocation = companylocation;
	}

	public String getCompanyemail() {
		return companyemail;
	}

	public void setCompanyemail(String companyemail) {
		this.companyemail = companyemail;
	}

	public String getQualification_required() {
		return qualification_required;
	}

	public void setQualification_required(String qualification_required) {
		this.qualification_required = qualification_required;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public LocalDate getPosteddate() {
		return posteddate;
	}

	public void setPosteddate(LocalDate posteddate) {
		this.posteddate = posteddate;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyname=" + companyname + ", companylocation=" + companylocation
				+ ", companyemail=" + companyemail + ", qualification_required=" + qualification_required + ", role="
				+ role + ", skills=" + skills + ", posteddate=" + posteddate + ", salary=" + salary + ", appliedJob="
				+ appliedJob + "]";
	}
	
	
    
	
}
