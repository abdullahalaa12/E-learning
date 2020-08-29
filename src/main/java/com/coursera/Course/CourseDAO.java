package com.coursera.Course;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import javax.servlet.http.Part;

import com.coursera.User.User;

public class CourseDAO
{
	Connection conn;
	
	public CourseDAO()
	{
		Connect();
	}
	
	private void  Connect()
	{
		try {
    	   	
    	   	String DataBaseURL = "jdbc:sqlserver://localhost:1433;databaseName=testdb;integratedSecurity=true;";
    	   	conn= DriverManager.getConnection(DataBaseURL);
    	   	
		} catch (SQLException e){
			e.printStackTrace();	
		}
	}
	
	
	
	public  String getBase64Img(InputStream inputStream)
	{
		String Base64Img=null;
		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			 
			while ((bytesRead = inputStream.read(buffer)) != -1) {
			    outputStream.write(buffer, 0, bytesRead);
			}
			
			byte[] imageBytes = outputStream.toByteArray();
			 
			Base64Img = Base64.getEncoder().encodeToString(imageBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "data:image/jpg;base64,"+Base64Img;
	}
	public void AddCourse(int person_id,String Name,String Field,LocalDate StartDate,LocalDate EndDate , Date Duration) 
	{
		String query="{call AddCourse(?,?,?,?,?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setString(1,Name);
			Call.setString(2,Field);
			Call.setDate(3, Date.valueOf(StartDate));
			Call.setDate(4, Date.valueOf(EndDate));
			Call.setDate(5, Duration);
			Call.setInt(6, person_id);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
		
		
	}
	public void DeleteCourse(int course_id) 
	{
		String query="{call DeleteCourse(?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, course_id);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}

	}
	public ArrayList<Course> ShowCourses(int userid) {
		
		String query="{call ShowCourses(?)}";
		String query2="{call getInstructorID(?)}";
		String query3="{call getInstructorInfo(?)}";
		int InstructorID;
		ArrayList<Course> Courses=new ArrayList<Course>();
		try {
			CallableStatement Call=conn.prepareCall(query);
			Call.setInt(1,userid);
			Call.execute();
			ResultSet rs=Call.getResultSet();
			while(rs.next())
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
				Courses.add(course);
				CallableStatement Call2=conn.prepareCall(query2);
				Call2.setInt(1, Courseid);
				Call2.execute();
				ResultSet ds = Call2.getResultSet();
				if (ds.next())
				{
				InstructorID = ds.getInt(1);
				CallableStatement Call3=conn.prepareCall(query3);
				Call3.setInt(1, InstructorID);
				Call3.execute();
				ResultSet rs2 = Call3.getResultSet();
				if (rs2.next())
				{
					String InstructorName = rs2.getString("fullname");
					String InstructorPhoto=getBase64Img(rs2.getBlob("Photo").getBinaryStream());
					course.setInstructorFullname(InstructorName);
					course.setInstructorPhoto(InstructorPhoto);
				}	
				}
		}
		}
			catch (SQLException e){
			e.printStackTrace();	
		}
		
		
		return Courses;
		
		
	}
	
	public void AddAnnouncement(String announce_text , Date date  , int course_id) 
	{
		String query="{call AddAnnouncement(?,?,?)}";
		try
		{
		CallableStatement Call = conn.prepareCall(query);
		Call.setString(1, announce_text);
		Call.setDate(2, date);
		Call.setInt(3, course_id);
		Call.execute();
		
		}
		catch (SQLException e){
			e.printStackTrace();	
		}

	}
	public void DeleteAnnouncement(int announce_id)
	{
		String query="{call DeleteAnnouncement(?)}";
		try
		{
		CallableStatement Call = conn.prepareCall(query);
		Call.setInt(1, announce_id);
		Call.execute();
		}
	  catch (SQLException e) {
		e.printStackTrace();
	} 
		
	}
	
	public void ModifyAnnouncement(int announce_id , String newannounce_text) 
	{
		String query="{call ModifyAnnouncement(?,?)}";
		try
		{
		CallableStatement Call = conn.prepareCall(query);
		Call.setInt(1, announce_id);
		Call.setString(2, newannounce_text);
		Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
		
	}
	
	public ArrayList<String> getannouncement(int course_id)
	{
		ArrayList<String> ann = new ArrayList<String>();
		String query="{call getannouncement(?)}";
		try
		{
		CallableStatement Call = conn.prepareCall(query);
		Call.setInt(1, course_id);
		Call.execute();
		ResultSet rs = Call.getResultSet();
		while(rs.next())
		{
			String announce = rs.getString(2);
			ann.add(announce);
		}
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
		return ann;
	}
	
	
	public void Enrollcourse(int course_id , int user_id)
	{
		String query="{call AddCourseToPerson(?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, user_id);
			Call.setInt(2, course_id);
			Call.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
