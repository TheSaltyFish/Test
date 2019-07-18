package practice;

import java.io.IOException;
import java.lang.reflect.*;
import java.text.*;
import java.util.Properties;

public class RefectionTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		Properties p = new Properties();
		p.load(TestUserService.class.getResourceAsStream("conf.properties"));

		String imp = p.getProperty("UserServiceImp");
		Class clazz = Class.forName(imp);

		UserService userService = (UserService)clazz.newInstance();
		userService.addUser();
		}
}

