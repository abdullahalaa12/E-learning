package com.coursera.Comment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import com.coursera.User.User;
import com.coursera.User.UserDAO;

import java.sql.ResultSet;

public class CommentDAO 
{
	Connection conn;
	
	public CommentDAO()
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
	
	public ArrayList<Comment>getcomments(int course_id)
	{
		ArrayList<Comment> com = new ArrayList<Comment>();
		try
		{
			String query = "{call getcomments(?)}";
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, course_id);
			Call.execute();
			ResultSet rs=Call.getResultSet();
			while(rs.next())
			{
			int comment_id = rs.getInt("comment_id");
			int user_id = rs.getInt("user_id"); // using user id get photo and email
			String comment = rs.getString("comment");
			String q = "{call getphotoandemail(?)}";
			CallableStatement Cl = conn.prepareCall(q);
			Cl.setInt(1, user_id);
			Cl.execute();
			ResultSet ds =Cl.getResultSet();
			if (ds.next())
			{
			String photo  = getBase64Img(ds.getBlob("Photo"));
			String email = ds.getString("Email");
			com.add(new Comment(comment_id,email,comment,photo));
			}
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return com;
		
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
	// getallcomment with email , and photo
	// if he give me userid , comment , courseid
	
	
}
