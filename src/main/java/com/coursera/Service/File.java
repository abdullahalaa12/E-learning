package com.coursera.Service;

public class File {
	
	private int FileID;
	private String UploadedFile;
	private String FileTitle;
	public static int NumberOfFiles=0;
	
	public File(String UploadedFile, String FileTitle) {
		NumberOfFiles++;
		this.FileID = NumberOfFiles;
		this.UploadedFile = UploadedFile;
		this.FileTitle = FileTitle;
	}

	public String getUploadedFile() {
		return UploadedFile;
	}

	public void setUploadedFile(String UploadedFile) {
		this.UploadedFile = UploadedFile;
	}

	public String getFileTitle() {
		return FileTitle;
	}

	public void setFileTitle(String FileTitle) {
		this.FileTitle = FileTitle;
	}

	public void setFileID(int FileID) {
		this.FileID = FileID;
	}
	
	
	
	
}
