package com.coursera.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.Base64;
import javax.servlet.http.Part;


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
				String Photo = getBase64Img(rs.getBlob("Photo").getBinaryStream());
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
							Photo,Educationlevel,Company,Joptitle,Department,Website,Gender);
				}
				else
				{
					ReturnedUser=new Student(id,Email,Password,fullname,Nationality,Phone,Birthdate,Age,
							Photo,Educationlevel,Company,Joptitle,Department,Website,Gender);
				}
			}
		} catch (SQLException e){
			e.printStackTrace();	
		}
		
		return ReturnedUser;
	}
	
	public boolean Singup(String Email,String Password,String FirstName,String LastName,String Nationality,String Phone,LocalDate Birthdate,
			Part Photo,int Educationlevel,String TypeOfUser,String Gender)
	{
		short out=-1;
		String query="{call SignUp(?,?,?,?,?,?,?,?,?,?,?)}";
		if(TypeOfUser.equals("Instructor"))
			Educationlevel=-1;
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
			Call.setString(9,TypeOfUser);
			Call.setString(10,Gender);
			Call.registerOutParameter(11, Types.SMALLINT);
			Call.execute();
			
			out=Call.getShort(11);
			
		} catch (SQLException e){
			e.printStackTrace();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (out == 0);
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

}
