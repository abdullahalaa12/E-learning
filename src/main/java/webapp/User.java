package webapp;

public abstract class User
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
	
	public abstract String getType();

	
	public User(String name,String password)
	{
		this.name=name;
		this.password=password;
	}
}
class Student extends User
{
	public Student(String name,String password)
	{
		super(name,password);
	}
	
	@Override
	public String getType()
	{
		return "Student";
	}
}
class Instructor extends User
{
	public Instructor(String name,String password)
	{
		super(name,password);
	}
	
	@Override
	public String getType()
	{
		return "Instructor";
	}
}
