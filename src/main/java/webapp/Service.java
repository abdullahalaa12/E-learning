package webapp;

public class Service {
static public boolean LoginValidation(String name,String password)
{
	if(name.equals("abdullah")&&password.equals("123"))
		return true;
	return false;
}
}
