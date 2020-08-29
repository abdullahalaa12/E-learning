package com.coursera.User;

import java.sql.Date;
import java.time.LocalDate;


public abstract class User
{
	private final int id;
	private String Email;
	private String Password;
	private String fullname;
	private String Nationality;
	private String Phone;
	private LocalDate Birthdate;
	private int Age;
	private String Photo;
	private int Educationlevel;
	private String Company;
	private String Joptitle;
	private String Department;
	private String Website;
	private String Gender;
	
	
	public User(int id,String fullname,String Photo) {
		this.id = id;
		this.fullname = fullname;
		this.Photo = Photo;
	}
	public User(int id,String Email,String Password,String fullname,String Nationality,String Phone,Date Birthdate,int Age,
			String Photo,int Educationlevel,String Company,String Joptitle,String Department,String Website,String Gender)
	{
		this.id=id;
		this.Email=Email;
		this.Password=Password;
		this.fullname=fullname;
		this.Nationality=Nationality;
		this.Phone=Phone;
		this.Birthdate=Birthdate.toLocalDate();
		this.Age=Age;
		this.Photo=Photo;
		this.Educationlevel=Educationlevel;
		this.Company=Company;
		this.Joptitle=Joptitle;
		this.Department=Department;
		this.Website=Website;
		this.Gender=Gender;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}
	
	public void setGender(String Gender) {
		this.Gender = Gender;
	}
	public String getGender() {
		return Gender;
	}
	public String getBirthdate() {
		return Birthdate.toString();
	}

	public void setBirthdate(Date birthdate) {
		Birthdate = birthdate.toLocalDate();
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public int getEducationlevel() {
		return Educationlevel;
	}

	public void setEducationlevel(int educationlevel) {
		Educationlevel = educationlevel;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getJoptitle() {
		return Joptitle;
	}

	public void setJoptitle(String joptitle) {
		Joptitle = joptitle;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public int getId() {
		return id;
	}
	
	public abstract String getUserType();
}


class Student extends User
{
	public Student(int id,String Email,String Password,String fullname,String Nationality,String Phone,Date Birthdate,int Age,
			String Photo,int Educationlevel,String Company,String Joptitle,String Department,String Website,String Gender)
	{
		super(id,Email,Password,fullname,Nationality,Phone,Birthdate,Age,
				Photo,Educationlevel,Company,Joptitle,Department,Website,Gender);
	}
	
	@Override
	public String getUserType()
	{
		return "Student";
	}
}


class Instructor extends User
{
	public Instructor(int id,String fullname,String Photo) {
		super(id, fullname, Photo);
	}
	public Instructor(int id,String Email,String Password,String fullname,String Nationality,String Phone,Date Birthdate,int Age,
			String Photo,int Educationlevel,String Company,String Joptitle,String Department,String Website,String Gender)
	{
		super(id,Email,Password,fullname,Nationality,Phone,Birthdate,Age,
				Photo,Educationlevel,Company,Joptitle,Department,Website,Gender);
	}
	
	@Override
	public String getUserType()
	{
		return "Instructor";
	}
}

