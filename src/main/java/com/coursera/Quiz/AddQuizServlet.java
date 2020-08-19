package com.coursera.Quiz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Main/Course/AddQuiz")
public class AddQuizServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/Pages/Course.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		QuizDAO dao=new QuizDAO();
		dao.Connect();
		
		int counter=Integer.parseInt(request.getParameter("QuestionCounter"));
		
		for(int i=0;i<counter;i++)
		{
			boolean isCorrect=true;
			String Q=request.getParameter(i+"Q");
			System.out.println("Qusetion "+(i+1)+" : "+Q);
			for(int j=0;j<4;j++)
			{
				String A=request.getParameter(i+"A"+j);
				System.out.println("Answer "+(j+1)+" : "+A);
				isCorrect=false;
			}
		}
		
		response.sendRedirect("/Main/Course");
	}
}
