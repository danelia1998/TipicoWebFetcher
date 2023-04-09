package com.example.tipico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDatabase {
	private Connection conn;

	public JobDatabase() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/tipico_careers";
		String user = "Tipico";
		String password = "Tipico1998!";
		conn = DriverManager.getConnection(url, user, password);
	}


//	Create Jobs ---
//	CREATE TABLE jobs (
//		title VARCHAR(255) NOT NULL,
//	description TEXT,
//	location VARCHAR(255),
//	);
	public void addJob(Job job) throws SQLException {
		String sql = "INSERT IGNORE INTO jobs (title, department, location) VALUES (?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, job.getTitle());
		stmt.setString(2, job.getDepartment());
		stmt.setString(3, job.getLocation());
		stmt.executeUpdate();
	}

	public List<Job> getAllJobs() throws SQLException {
		List<Job> jobs = new ArrayList<>();
		String sql = "SELECT title, department, location FROM jobs";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			String title = rs.getString("title");
			String department = rs.getString("department");
			String location = rs.getString("location");
			Job job = new Job(title, department, location);
			jobs.add(job);
		}
		return jobs;
	}
}