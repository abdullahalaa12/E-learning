package com.coursera.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Section {
	private int SectionID;
	private String SectionTitle;
	private LocalDateTime DateTime;
	private ArrayList<File> Files = new ArrayList<File>();
	private ArrayList<Quiz> Quizes = new ArrayList<Quiz>();
	public static int NumberOfSections=0;
	
	public Section(String sectionTitle, LocalDateTime dateTime) {
		NumberOfSections++;
		this.SectionID=NumberOfSections;
		this.SectionTitle = sectionTitle;
		this.DateTime = dateTime;
	}

	public String getSectionTitle() {
		return SectionTitle;
	}

	public void setSectionTitle(String sectionTitle) {
		SectionTitle = sectionTitle;
	}

	public LocalDateTime getDateTime() {
		return DateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		DateTime = dateTime;
	}

	public void setSectionID(int sectionID) {
		SectionID = sectionID;
	}
	
	
	

}
