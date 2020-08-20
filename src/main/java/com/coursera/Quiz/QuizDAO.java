package com.coursera.Quiz;
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

import com.coursera.File.File;

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
	public void Addquiz(String title , int course_id)
	{
		try
		{
			String query = "{call Addquiz(?,?)}";
			CallableStatement Call=conn.prepareCall(query);
			Call.setString(1,title);
			Call.setInt(2,course_id);
			Call.execute();
		}
		catch (SQLException e){
			e.printStackTrace();	
		} 
	}
	public void Deletequiz(int quiz_id)
	{
		try
		{
			String query = "{call Deletequiz(?)}";
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, quiz_id);
			Call.execute();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public ArrayList<Quiz> getquiz(int course_id)
	{
		                    // heap
		ArrayList<Quiz> Q = new ArrayList<Quiz>();
		try
		{
			String query = "{call getquiz(?)}";
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, course_id);
			Call.execute();
			ResultSet rs=Call.getResultSet();
			while(rs.next())
			{
			int q_id = rs.getInt(1);
		    String title = rs.getString(2);
		    Quiz q =new Quiz(q_id,title,course_id);
			Q.add(q);
			q.setQues(getQuestion(q_id));			
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return Q;
	}

	public ArrayList<Question> getQuestion(int quiz_id)
	{
		
		ArrayList<Question> Ques = new ArrayList<Question>();
		try
		{
			String query = "{call getQuestions(?)}";
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, quiz_id);
			Call.execute();
			ResultSet rs = Call.getResultSet();
			while(rs.next())
			{
				int Question_id = rs.getInt(1);
				String Question_name = rs.getString(2);
				Question q = new Question(Question_id,Question_name,quiz_id);
				Ques.add(q);
				q.setCh(getchoise(Question_id));
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return Ques; 
	}
	public ArrayList<Choise> getchoise(int Question_id)
	{
		ArrayList<Choise> ch = new ArrayList<Choise>();
		try
		{
			String query = "{call getchoise(?)}";
			CallableStatement Call = conn.prepareCall(query);
			Call.setInt(1, Question_id);
			Call.execute();
			ResultSet rs = Call.getResultSet();
			while(rs.next())
			{
				int choise_id = rs.getInt(1);
				String choise = rs.getString(3);
				boolean iscorrect = rs.getBoolean(4);
				ch.add(new Choise(choise_id,choise,Question_id,iscorrect));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ch;
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
	public void deleteQuestion(int question_id)
	{
		try
		{
		String query = "{call deletequestion(?)}";
		CallableStatement Call = conn.prepareCall(query);
		Call.setInt(1,question_id);
		Call.execute();
		}
		catch (SQLException e)
		{
		e.printStackTrace();
		}
	}
}
