package com.coursera.Quiz;
import java.util.*;

public  class Quiz 
{
	private final int course_id;
	private final int quiz_id;
	private String title;
	private ArrayList<Question> Ques; 
	
	public Quiz(int course_id, String title  , int quiz_id)
	{
		this.course_id = course_id;
		this.quiz_id = quiz_id;
		this.title = title;
		Ques = new ArrayList<Question>();
	}
	public int getCourse_id() {
		return course_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getQuiz_id() {
		return quiz_id;
	}
	public ArrayList<Question> getQues() {
		return Ques;
	}
	public void setQues(ArrayList<Question> ques) {
		Ques = ques;
	}
	
}

class Question
{
	private final int idQuestion;
	private String question;
	private final int Quiz_id;
	private ArrayList<Choise> ch;
	public Question(int idQuestion , String question , int Quiz_id)
	{
		this.idQuestion = idQuestion;
		this.question = question;
		this.Quiz_id = Quiz_id;
		ch = new ArrayList<Choise>();

	}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public ArrayList<Choise> getCh() {
	return ch;
}
public void setCh(ArrayList<Choise> ch) {
	this.ch = ch;
}
public int getQuiz_id() {
	return Quiz_id;
}
public int getIdQuestion() {
	return idQuestion;
}

}
class Choise
{
private final int choiseID;
private String choise;
private final int Question_id;
private boolean iscorrect;
public Choise(int choiseID , String choise ,int Question_id , boolean iscorrect )
{
	this.setChoise(choise);
	this.choiseID = choiseID;
	this.setIscorrect(iscorrect);
	this.Question_id = Question_id;
}
public int getChoiseID() {
	return choiseID;
}
public String getChoise() {
	return choise;
}
public void setChoise(String choise) {
	this.choise = choise;
}
public int getQuestion_id() {
	return Question_id;
}
public boolean isIscorrect() {
	return iscorrect;
}
public void setIscorrect(boolean iscorrect) {
	this.iscorrect = iscorrect;
}

}
