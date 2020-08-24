package com.coursera.Quiz;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Main/Course/DeleteQuiz")
public class DeleteQuizServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int FileID=Integer.parseInt(request.getParameter("QuizID"));
		QuizDAO dao=new QuizDAO();

		response.sendRedirect("/Main/Course");
	}
	
}
