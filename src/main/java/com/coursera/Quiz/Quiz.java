package com.coursera.Quiz;


public  class Quiz 
{
	private final int course_id;
	private final int quiz_id;
	private String title;
	
	public Quiz(int course_id, String title  , int quiz_id)
	{
		this.course_id = course_id;
		this.quiz_id = quiz_id;
		this.title = title;
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
}

class Question
{
	private  int idQ;
	private String question;
	private Choise [] ch;
	private int correct_idx;
	public Question(int idQ , String question , Choise [] ch , int correct_idx )
	{
		this.idQ = idQ;
		this.question = question;
		this.ch = ch;
		this.correct_idx = correct_idx;
	}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public int correct_idx() {
	return correct_idx;
}
public void correct_idx(int correct_idx) {
	this.correct_idx = correct_idx;
}
public int getIdQ() {
	return idQ;
}
public Choise [] getCh() {
	return ch;
}
public void setCh(Choise [] ch) {
	this.ch = ch;
}

}
class Choise
{
private int choiseID;
private String choise;
public int getChoiseID() {
	return choiseID;
}
public void setChoiseID(int choiseID) {
	this.choiseID = choiseID;
}
public String getChoise() {
	return choise;
}
public void setChoise(String choise) {
	this.choise = choise;
}
}
