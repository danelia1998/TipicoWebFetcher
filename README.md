# Automated Job Data Extraction and Storage Project

## Introduction
The goal of this project is to automate the process of extracting job information from the Tipico Careers website and storing it in a database. The job information will consist of job titles, departments, and locations, and will be stored in a database with unique entries using a composite key. The project will be implemented using Java, Selenium WebDriver, Cucumber, and a database of the user's choice.

## Prerequisites
To run the project, the following software must be installed:

- Java Development Kit (JDK)
- Maven
- Selenium WebDriver
- Cucumber
- A database of the user's choice (e.g., MySQL, MongoDB)

## Project Setup
The project can be set up using the following steps:

1. Install the JDK and Maven on your machine.
2. Create a new Maven project in your preferred IDE.
3. Add the Selenium and Cucumber dependencies to the project's pom.xml file.
4. Create a Cucumber feature file with the scenario for the given requirement.
5. Implement the step definitions for the feature file using Selenium WebDriver and database connectivity.

## Feature File
The feature file will consist of the following scenario:

Feature: Fetch jobs from the Tipico Careers website and store them in a database

Scenario: Fetch all job titles, departments, and locations from the Tipico Careers website and store them in a database
Given I am on the Tipico Careers website
When I fetch all job titles, departments, and locations
Then I store the job data in a database

## Step Definitions
The step definitions will consist of the following methods:

- `i_am_on_the_tipico_careers_website()` - Initializes the WebDriver and navigates to the Tipico Careers website.
- `i_fetch_all_job_titles_departments_and_locations()` - Finds all the job entries on the website and extracts the job data.
- `i_store_the_job_data_in_a_database()` - Connects to the database and stores the job data using a composite key.

To successfully run the automation project for the given requirement, the user should have a pre-created database called "tipico-careers" with a "jobs" table. The "jobs" table should have columns for "title", "description", and "location".

The user should ensure that their SQL server is up-to-date and running before running the project.

Here is a sample SQL query to create the "jobs" table:

```sql
CREATE TABLE jobs (
    title VARCHAR(255) NOT NULL,
    description TEXT,
    location VARCHAR(255)
);
It is important to note that the SQL query should be executed on the correct database to create the "jobs" table.

If the user wants to use a different database management system or a different schema for the "jobs" table, they will need to modify the project code accordingly.
