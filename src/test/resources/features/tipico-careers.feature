Feature: Scrape jobs from Tipico Careers website

Scenario: Fetch all jobs and store them in a database
Given I have a job database
When I scrape the jobs from the website
Then I add the jobs to the database

Scenario: Retrieve jobs from the database
Given I have a job database
When I scrape the jobs from the website
Then I add the jobs to the database
And I can retrieve the jobs from the database