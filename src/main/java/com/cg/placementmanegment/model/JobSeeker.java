package com.cg.placementmanegment.model;
import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="jobseeker")
public class JobSeeker {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="userid")
	private Integer userid;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phoneno")
	private String phoneno;
	
	@Column(name="location")
	private String location;
	
	@Column(name="experience")
	private String experience;
	
	@Column(name="skills")
	private String skills;
	
	@Column(name="email")
	private String email;
	
	@Column(name="education")
	private String education;
	
	@Column(name="passoutyear")
	private String passoutyear;
	
	//@Temporal(TemporalType.DATE)

	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="age")	
    private Integer age;
	
	@Column(name="gender")
	private String gender ;
    
	@Column(name="interview_Status")
	private String interview_status ;
    

	 @OneToMany(mappedBy="jobSeeker")   
     List<AppliedJob> appliedJob;
	 
		public JobSeeker() {
		   
	}

		public Integer getUserid() {
			return userid;
		}

		public void setUserid(Integer userid) {
			this.userid = userid;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		
		public String getPhoneno() {
			return phoneno;
		}

		public void setPhoneno(String phoneno) {
			this.phoneno = phoneno;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getExperience() {
			return experience;
		}

		public void setExperience(String experience) {
			this.experience = experience;
		}

		public String getSkills() {
			return skills;
		}

		public void setSkills(String skills) {
			this.skills = skills;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getEducation() {
			return education;
		}

		public void setEducation(String education) {
			this.education = education;
		}

		public String getPassoutyear() {
			return passoutyear;
		}

		public void setPassoutyear(String passoutyear) {
			this.passoutyear = passoutyear;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getInterview_status() {
			return interview_status;
		}

		public void setInterview_status(String interview_status) {
			this.interview_status = interview_status;
		}

		public List<AppliedJob> getAppliedJob() {
			return appliedJob;
		}

		public void setAppliedJob(List<AppliedJob> appliedJob) {
			this.appliedJob = appliedJob;
		}

		

		public JobSeeker(Integer userid, String username, String password, String name, String phoneno, String location,
				String experience, String skills, String email, String education, String passoutyear, Date dob,
				Integer age, String gender, String interview_status, List<AppliedJob> appliedJob) {
			super();
			this.userid = userid;
			this.username = username;
			this.password = password;
			this.name = name;
			this.phoneno = phoneno;
			this.location = location;
			this.experience = experience;
			this.skills = skills;
			this.email = email;
			this.education = education;
			this.passoutyear = passoutyear;
			this.dob = dob;
			this.age = age;
			this.gender = gender;
			this.interview_status = interview_status;
			this.appliedJob = appliedJob;
		}

		@Override
		public String toString() {
			return "JobSeeker [userid=" + userid + ", username=" + username + ", password=" + password + ", name="
					+ name + ", phoneno=" + phoneno + ", location=" + location + ", experience=" + experience
					+ ", skills=" + skills + ", email=" + email + ", education=" + education + ", passoutyear="
					+ passoutyear + ", dob=" + dob + ", age=" + age + ", gender=" + gender + ", interview_status="
					+ interview_status + ", appliedJob=" + appliedJob + "]";
		}
		
	

	}


	

	



	


	



	




