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
	
	public UserDAO()
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
				String Photo = getBase64Img(rs.getBlob("Photo"));
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
		
		return (out == 0);
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
	public void AddCourse(int person_id,String Name,String Field,Date StartDate,Date EndDate , Date Duration) 
	{
		String query="{call AddCourse(?,?,?,?,?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setString(1,Name);
			Call.setString(2,Field);
			Call.setDate(3, StartDate);
			Call.setDate(4, EndDate);
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
				String InstructorPhoto=getBase64Img(rs2.getBlob("Photo"));
				course.setInstructor(new Instructor(InstructorID,InstructorName,InstructorPhoto));
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
	
	public void editfullname(int userid , String fullname)
	{
		String query="{call editfullname(?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setString(2,fullname);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
	}
	public boolean editEmail(int userid , String Email)
	{
		short out = -1;
		String query="{call editEmail(?,?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setString(2,Email);
			Call.registerOutParameter(3, Types.SMALLINT);
			Call.execute();
			out = Call.getShort(3);
			
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
		return (out == 0);
	}
	public void editPassword(int userid ,String Password)
	{
		String query="{call editPassword(?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setString(2,Password);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
	}
	public void editNationality(int userid,String Nationality)
	{
		String query="{call editNationality(?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setString(2,Nationality);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
	}
	public void editPhone(int userid,String Phone)
	{
		String query="{call editPhone(?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setString(2,Phone);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
	}
	public void editBirthdate(int userid , String BirthYear , String BirthMonth , String Birthday)
	{
		String query="{call editBirthdate(?,?)}";
		try
		{
			LocalDate Birthdate=LocalDate.of(Integer.parseInt(BirthYear),Integer.parseInt(BirthMonth),Integer.parseInt(Birthday));
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setDate(2,Date.valueOf(Birthdate));
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
	}
	public void editEducationlevel(int userid , int Educationlevel)
	{
		String query="{call editEducationlevel(?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setInt(2,Educationlevel);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
	}
	public void editAge(int userid , int Age)
	{
		String query="{call editAge(?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setInt(2,Age);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
	}
	public void editJoptitle(int userid , String Joptitle)
	{
		String query="{call editJoptitle(?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setString(2,Joptitle);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
	}
	public void editCompany(int userid,String Company)
	{
		String query="{call editCompany(?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setString(2,Company);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
	}
	public void editDepartment(int userid,String Department)
	{
		String query="{call editDepartment(?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setString(2,Department);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
	}
    public void editWebsite(int userid,String Website)
	{
		String query="{call editWebsite(?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setString(2,Website);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
	}
    public void editGender(int userid,String Gender)
	{
		String query="{call editGender(?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setString(2,Gender);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
	}
    public void editPhoto(int userid,Part Photo)
	{
		String query="{call editPhoto(?,?)}";
		try
		{
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, userid);
			Call.setBlob(2, Photo.getInputStream());
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}
		catch (IOException v) {
			// TODO Auto-generated catch block
			v.printStackTrace();
		}
	}
	public void addcomment(int userid , String comment , int courseid )
	{
		String query="{call addcomment(?,?,?)}";
		try
		{
		CallableStatement Call = conn.prepareCall(query);
		Call.setInt(1, userid);
		Call.setString(2, comment);
		Call.setInt(3, courseid);
		Call.execute();
			
		}
		catch (SQLException e){
			e.printStackTrace();	
		}	
	}
	public void editcomment(int commentid , String newcomment)
	{
		String query="{call editcomment(?,?)}";
		try
		{
		CallableStatement Call = conn.prepareCall(query);
		Call.setInt(1, commentid);
		Call.setString(2, newcomment);
		Call.execute();
			
		}
		catch (SQLException e){
			e.printStackTrace();	
		}	
	}
	public void deletecomment(int commentid)
	{

		String query="{call deletecomment(?)}";
		try
		{
		CallableStatement Call = conn.prepareCall(query);
		Call.setInt(1, commentid);
		Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		}		
		}

}
