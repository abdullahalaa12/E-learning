package webapp;

import java.util.ArrayList;

class User
{
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean equals(User AnotherUser)
	{
		if(AnotherUser.name.equals(this.name)
				&&AnotherUser.password.equals(this.password))
			return true;
		return false;
	}

	
	public User(String name,String password)
	{
		this.name=name;
		this.password=password;
	}
}

public class Service 
{
	private static ArrayList<User> UsersData=new ArrayList<User>();
	
	public static boolean LoginValidation(User user)
	{
		for(int i=0;i<UsersData.size();i++)
			if(UsersData.get(i).equals(user))
				return true;
		return false;
	}
	public static void Register(String name,String password)
	{
		User newUser=new User(name,password);
		UsersData.add(newUser);
	}
}
