package com.cg.placementmanegment;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import com.cg.placementmanegment.model.Admin;
import com.cg.placementmanegment.model.JobSeeker;
import com.cg.placementmanegment.model.Recruiter;
import com.cg.placementmanegment.service.AdminService;
import com.cg.placementmanegment.service.JobSeekerService;
import com.cg.placementmanegment.service.RecruiterService;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlacementManegementApplicationTests {
	
	@Autowired
	private AdminService adminService;
	
	
	@Autowired
	  private RecruiterService recruiterService;
	 
	@Autowired
	  private JobSeekerService jobSeekerService;
	 
	
	
	/*
	 * @MockBean private RecruiterRepository recruiterRepository;
	 * 
	 * @MockBean private JobSeekerRepository jobSeekerRepository;
	 */
	@Test
	public void saveAdminTest() {
		
		Admin admin = new Admin();
		
		admin.setUsername("suman");
		admin.setPassword("7654321");
		admin.setEmail("suman@gmail.com");
		assertEquals(admin, adminService.addAdmin(admin));
	}
		@Test
		public void testJobSeeker() {
			
			JobSeeker jobSeeker = new JobSeeker();
			jobSeeker.setName("Pavitra Sonar");
			jobSeeker.setUsername("pavitra12");
			jobSeeker.setPassword("pavitra");
			jobSeeker.setEmail("pavitra@gmail.com");
			jobSeeker.setEducation("BE");
			jobSeeker.setAge(22);
			jobSeeker.setExperience("fresher");
			jobSeeker.setGender("female");
			jobSeeker.setLocation("Pune");
			jobSeeker.setPassoutyear("2020");
			jobSeeker.setPhoneno("963258741");
			jobSeeker.setSkills("C++,OOP");
			//jobSeeker.setDob('2021/2/21');
			assertNotNull(jobSeekerService.addJobseeker(jobSeeker));

			}
		@Test
		public void testRecruiter() {
			
			Recruiter recruiter = new Recruiter();
			recruiter.setUsername("wipro");
			recruiter.setPassword("wipro123");
			recruiter.setEmail("wipro@gmail.com");
			assertNotNull(recruiterService.addRecruiter(recruiter));

			}

	}


