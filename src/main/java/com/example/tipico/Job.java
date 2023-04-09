package com.example.tipico;

public class Job {
	private String title;
	private String department;
	private String location;

	public Job(String title, String department, String location) {
		this.title = title;
		this.department = department;
		this.location = location;
	}

	public String getTitle() {
		return title;
	}

	public String getDepartment() {
		return department;
	}

	public String getLocation() {
		return location;
	}
}