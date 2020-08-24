package com.coursera.Comment;

public class Comment 
{
	private final int Comment_id;
	private String Comment;
	private String Email;
	private String Photo;
	
	public Comment(int Comment_id , String Email , String Comment , String Photo)
	{
		this.Comment = Comment;
		this.Comment_id = Comment_id;
		this.Email = Email;
		this.Photo = Photo;
	}

	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public int getComment_id() {
		return Comment_id;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}

	
	
}

