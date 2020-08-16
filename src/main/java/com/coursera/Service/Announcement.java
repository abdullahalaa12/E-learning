package com.coursera.Service;
import java.sql.Date;
import java.time.LocalDate;

public class Announcement {
	private int Announcement_id;
	private String Paragraph;
	private LocalDate date;
	public static int NumberOfAnnouncement=0;
	
	public Announcement(String Paragraph, LocalDate date) {
		NumberOfAnnouncement++;
		this.Announcement_id=NumberOfAnnouncement;
		this.Paragraph = Paragraph;
		this.date = date;
	}
	
	
	

}
