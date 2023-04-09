package com.example.tipico;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import java.sql.SQLException;
import java.util.List;

public class StepDefinitions
{
	private Scraper scraper;
	private List<Job> jobs;
	private JobDatabase jobDatabase;

	@Given("I have a job database")
	public void i_have_a_job_database() throws SQLException {
		jobDatabase = new JobDatabase();
	}

	@When("I scrape the jobs from the website")
	public void i_scrape_the_jobs_from_the_website() {
		scraper = new Scraper();
		jobs = scraper.scrapeJobs();
	}


	@Then("I add the jobs to the database")
	public void i_add_the_jobs_to_the_database() throws SQLException {
		for (Job job : jobs) {
			jobDatabase.addJob(job);
		}
	}

	@Then("I can retrieve the jobs from the database")
	public void i_can_retrieve_the_jobs_from_the_database() throws SQLException {
		List<Job> jobsFromDatabase = jobDatabase.getAllJobs();
		for (Job job : jobs) {
			assert jobsFromDatabase.contains(job);
		}
	}


	@After
	public void tearDown() {
		scraper.close();
	}
}