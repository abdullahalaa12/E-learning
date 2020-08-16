package com.coursera.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class UserInteract {
	
	Connection conn;
	public void  Connect()
	{
		try {
    	   	
    	   	String DataBaseURL = "jdbc:sqlserver://localhost:1433;databaseName=testdb;integratedSecurity=true;";
    	   	conn= DriverManager.getConnection(DataBaseURL);
    	   	
		} catch (SQLException e){
			e.printStackTrace();	
		}
	}
	public void AddCourse(int CourseID,String Name,String Field,Date StartDate,Date EndDate,Date Duration) {}
	public void DeleteCourse() {}
	public void ShowCourses(User user) {
		
		String query="{call ShowCourses(?)}";
		try {
			CallableStatement Call=conn.prepareCall(query);
			Call.setInt(1,user.getId());
			Call.execute();
			ResultSet rs=Call.getResultSet();
			if(rs.next())
			{
				int Courseid=rs.getInt("courseID");
				String CourseName=rs.getString("Name");
				String Field=rs.getString("Field");
				Date StartDate=rs.getDate("StartDate");
				Date EndDate=rs.getDate("EndDate");
				Date Duration=rs.getDate("Duration");
				int NumberOfStudents=rs.getInt("NumberOfStudents");
				int NumberOfInstructors=rs.getInt("NumberOfInstructors");
				Course course = new Course(Courseid,CourseName,Field, StartDate, EndDate, Duration,NumberOfStudents,NumberOfInstructors);
				user.getCourses().add(course);
				
			}
		} catch (SQLException e){
			e.printStackTrace();	
		}
		
	}
	public void AddSection() {}
	public void DeleteSection() {}
	public void ShowSections() {}
	public void AddFile() {}
	public void DeleteFile() {}
	public void ShowFiles() {}
	public void AddAnnouncement() {}
	public void DeleteAnnouncement() {}
	public void ShowAnnouncements() {}
	
	
	

}
