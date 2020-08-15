package com.coursera.Service;

import java.util.ArrayList;


public class Service 
{
	private static ArrayList<User> UsersData=new ArrayList<User>();
	Student s;
	public static boolean LoginValidation(User user)
	{
		for(int i=0;i<UsersData.size();i++)
			if(UsersData.get(i).equals(user))
				return true;
		return false;
	}
	public static void Register(String name,String password)
	{
		//User newUser=new User(name,password);
		//UsersData.add(newUser);
	}
}
