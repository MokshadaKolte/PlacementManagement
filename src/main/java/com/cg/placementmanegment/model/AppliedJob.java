package com.cg.placementmanegment.model;

import java.time.LocalDate;
import java.time.ZoneId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="applied_job")
public class AppliedJob {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long appliedjobid;
	private String companyname;
    private String companylocation;
    private String companyemail;
    private String qualification_required;
    private String role;
    private String skills;
    private LocalDate posteddate = LocalDate.now(ZoneId.of("GMT+05:30"));
    
    @OneToOne
    @JoinColumn(name="company_id")
    Company company;
   
    @OneToOne
    @JoinColumn(name="jobseeker_id")
    JobSeeker jobSeeker;

	
    public AppliedJob() {
		
	}

	public AppliedJob(Long appliedjobid, String companyname, String companylocation, String companyemail,
			String qualification_required, String role, String skills, LocalDate posteddate, Company company,
			JobSeeker jobSeeker) {
		super();
		this.appliedjobid = appliedjobid;
		this.companyname = companyname;
		this.companylocation = companylocation;
		this.companyemail = companyemail;
		this.qualification_required = qualification_required;
		this.role = role;
		this.skills = skills;
		this.posteddate = posteddate;
		this.company = company;
		this.jobSeeker = jobSeeker;
	}

	public Long getAppliedjobid() {
		return appliedjobid;
	}

	public void setAppliedjobid(Long appliedjobid) {
		this.appliedjobid = appliedjobid;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	@Override
	public String toString() {
		return "AppliedJob [appliedjobid=" + appliedjobid + ", companyname=" + companyname + ", companylocation="
				+ companylocation + ", companyemail=" + companyemail + ", qualification_required="
				+ qualification_required + ", role=" + role + ", skills=" + skills + ", posteddate=" + posteddate
				+ ", company=" + company + ", jobSeeker=" + jobSeeker + "]";
	}
    
	
    
}
