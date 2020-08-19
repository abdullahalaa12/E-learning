package com.coursera.User;

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

import com.coursera.Course.Course;

public class UserDAO
{
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
	
	public User Login(String Email,String Password)
	{
		User ReturnedUser=null;
		String query="{call Login(?,?)}";
		try {
			CallableStatement Call=conn.prepareCall(query);
			Call.setString(1, Email);
			Call.setString(2, Password);
			Call.execute();
			ResultSet rs=Call.getResultSet();
			if(rs.next())
			{
				int id=rs.getInt("personID");
				String fullname=rs.getString("fullname");
				String Nationality=rs.getString("Nationality");
				String Phone=rs.getString("Phone");
				Date Birthdate=rs.getDate("Birthdate");
				int Age=rs.getInt("Age");
				String Photo=getBase64Img(rs.getBlob("Photo"));
				int Educationlevel=rs.getInt("Educationlevel");
				String Company=rs.getString("Company");
				String Joptitle=rs.getString("Joptitle");
				String Department=rs.getString("Department");
				String Website=rs.getString("Website");
				String Gender=rs.getString("Gender");
				String typeofuser=rs.getString("typeofuser");
				if(typeofuser.equals("Instructor"))
				{
					ReturnedUser=new Instructor(id,Email,Password,fullname,Nationality,Phone,Birthdate,Age,
							"data:image/jpg;base64,"+Photo,Educationlevel,Company,Joptitle,Department,Website,Gender,ShowCourses(id));
				}
				else
				{
					ReturnedUser=new Student(id,Email,Password,fullname,Nationality,Phone,Birthdate,Age,
							"data:image/jpg;base64,"+Photo,Educationlevel,Company,Joptitle,Department,Website,Gender,ShowCourses(id));
				}
			}
		} catch (SQLException e){
			e.printStackTrace();	
		}
		
		return ReturnedUser;
	}
	
	public boolean Singup(String Email,String Password,String FirstName,String LastName,String Nationality,String Phone,String Birthday,
			String BirthMonth,String BirthYear,Part Photo,int Educationlevel,String Company,String Joptitle,String Department,String Website,String TypeOfUser,String Gender)
	{
		short out=-1;
		String query="{call SignUp(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		if(TypeOfUser.equals("Instructor"))
			Educationlevel=-1;
		LocalDate Birthdate=LocalDate.of(Integer.parseInt(BirthYear),Integer.parseInt(BirthMonth),Integer.parseInt(Birthday));
		try {
			CallableStatement Call=conn.prepareCall(query);
			Call.setString(1, FirstName+" "+LastName);
			Call.setString(2, Email);
			Call.setString(3, Password);
			Call.setNString(4, Nationality);
			Call.setNString(5, Phone);
			Call.setDate(6, Date.valueOf(Birthdate));
			Call.setBlob(7, Photo.getInputStream());
			Call.setInt(8, Educationlevel);
			Call.setNString(9, Company);
			Call.setNString(10,Joptitle);
			Call.setNString(11, Department);
			Call.setNString(12,Website);
			Call.setString(13,TypeOfUser);
			Call.setString(14,Gender);
			Call.registerOutParameter(15, Types.SMALLINT);
			Call.execute();
			
			out=Call.getShort(15);
			
		} catch (SQLException e){
			e.printStackTrace();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(out==0)
			return true;
		else
			return false;
	}
	
	private  String getBase64Img(Blob ImgBlob)
	{
		InputStream inputStream;
		String Base64Img=null;
		try {
			inputStream = ImgBlob.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			 
			while ((bytesRead = inputStream.read(buffer)) != -1) {
			    outputStream.write(buffer, 0, bytesRead);
			}
			
			byte[] imageBytes = outputStream.toByteArray();
			 
			Base64Img = Base64.getEncoder().encodeToString(imageBytes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Base64Img;
	}
	public void AddCourse(int CourseID,String Name,String Field,Date StartDate,Date EndDate,Date Duration) {}
	public void DeleteCourse() {}
	public ArrayList<Course> ShowCourses(int userid) {
		
		String query="{call ShowCourses(?)}";
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
				
			}
		} catch (SQLException e){
			e.printStackTrace();	
		}
		
		
		return Courses;
		
		
	}
	
	public void AddAnnouncement() {}
	public void DeleteAnnouncement() {}
	public void ShowAnnouncements() {}
}
