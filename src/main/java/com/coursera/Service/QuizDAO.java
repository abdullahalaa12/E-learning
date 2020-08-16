package com.coursera.Service;
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
import java.util.Base64;
import javax.servlet.http.Part;

public class QuizDAO 
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
	public void makequiz(String title)
	{
		String query = "{call makequiz(?)}";
		try
		{
			CallableStatement Call=conn.prepareCall(query);
			Call.setString(1,title);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		} 
	}
	public void addQuestion(int quizid , String  question , String ch1 , String ch2  ,  String ch3 ,  String ch4  , int correct_index)
	{
	String query = "{call add_question(?,?,?,?,?,?,?)}";
	try
	{
		CallableStatement Call=conn.prepareCall(query);
		Call.setInt(1,quizid);
		Call.setString(2,question);
		Call.setString(3,ch1);
		Call.setString(4,ch2);
		Call.setString(5,ch3);
		Call.setString(6,ch4);
		Call.setInt(7,correct_index);
		Call.execute();
	}
	catch (SQLException e){
		e.printStackTrace();	
	} 

	}
	

}
