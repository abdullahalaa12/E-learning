package com.coursera.File;

import java.io.InputStream;

public class File {
	
	private final int  CourseID;
	private final int  FileID;
	private InputStream UploadedFile;
	private String FileTitle;
	private String FileType;
	
	public File(int CourseID,int FileID,InputStream UploadedFile,String FileTitle,String FileType) {
		this.CourseID=CourseID;
		this.FileID=FileID;
		this.UploadedFile=UploadedFile;
		this.FileTitle=FileTitle;
		this.FileType=FileType;
	}
	
	public InputStream getUploadedFile() {
		return UploadedFile;
	}

	public void setUploadedFile(InputStream uploadedFile) {
		UploadedFile = uploadedFile;
	}

	public String getFileTitle() {
		return FileTitle;
	}

	public void setFileTitle(String fileTitle) {
		FileTitle = fileTitle;
	}

	public String getFileType() {
		return FileType;
	}

	public void setFileType(String fileType) {
		FileType = fileType;
	}

	public int getCourseID() {
		return CourseID;
	}

	public int getFileID() {
		return FileID;
	}

	
}
