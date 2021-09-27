package test;

import beans.User;

public class Test {

	public static void main(String[] args) {
		User user = new User("Jsquyetnguyen@gmail.com","132456789");
		
		if(user.validate()){
			System.out.println("Bean validate OK.");
		}else {
			System.out.println(user.getMessage());
		}

	}

}
