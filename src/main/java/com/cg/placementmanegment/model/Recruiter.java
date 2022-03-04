package com.cg.placementmanegment.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recruiter")
public class Recruiter {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long recruiterid;

	private String username;
	private String password;
	private String email;
	public Recruiter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recruiter(Long recruiterid, String username, String password, String email) {
		super();
		this.recruiterid = recruiterid;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public Long getRecruiterid() {
		return recruiterid;
	}
	public void setRecruiterid(Long recruiterid) {
		this.recruiterid = recruiterid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Recruiter [recruiterid=" + recruiterid + ", username=" + username + ", password=" + password
				+ ", email=" + email + "]";
	}
	
}