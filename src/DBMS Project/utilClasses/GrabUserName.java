package utilClasses;

import frontEndGUI.LoginForm;

public class GrabUserName {
	
	LoginForm login;
	static String uname = "";
	
	public GrabUserName(String username)
	{
		uname = username;
	}
	
	public static String getGrabUserName() {
		return uname;
	}

}
