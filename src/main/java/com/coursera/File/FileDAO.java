package com.coursera.File;

import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Part;

public class FileDAO {

	Connection conn;
	public FileDAO()
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
	
	public ArrayList<File> getFiles(int CourseID)
	{
		ArrayList<File> FileArray=new ArrayList<File>();
		try {
			String query="{call getFiles(?)}";
			CallableStatement Call=conn.prepareCall(query);
			Call.setInt(1, CourseID);
			Call.execute();
			
			ResultSet rs=Call.getResultSet();
			
			while(rs.next())
			{
				int FileID=rs.getInt(1);
				Blob UploadedFile=rs.getBlob(2);
				String FileTitle=rs.getString(3);
				String FileType=rs.getString(4);
				
				FileArray.add(new File(CourseID,FileID,UploadedFile.getBinaryStream(),FileTitle,FileType));
			}
			
		} catch (SQLException e){
			e.printStackTrace();	
		}
		return FileArray;
	}
	
	public void addFile(Part UploadedFile,String FileTitle,String FileType,int CourseID)
	{
		try {
			String query="{call AddFile(?,?,?,?)}";
			CallableStatement Call=conn.prepareCall(query);
			Call.setBlob(1, UploadedFile.getInputStream());
			Call.setString(2, FileTitle);
			Call.setString(3, FileType);
			Call.setInt(4, CourseID);
			Call.execute();
			
		} catch (SQLException e){
			e.printStackTrace();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFile(int FileID)
	{
		try {
			String query="{call DeleteFile(?)}";
			CallableStatement Call=conn.prepareCall(query);
			Call.setInt(1, FileID);
			Call.execute();
			
		} catch (SQLException e){
			e.printStackTrace();	
		}
	}
}
