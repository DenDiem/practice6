package com.example.practice6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Practice6Application {


	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Practice6Application.class, args);
		UserService userService = applicationContext.getBean(UserService.class);
		UserEntity user = userService.createUser("firstName1", "lastName1");
		userService.createUser("firstName2", "lastName2");
		userService.createUser("22", "333");
		System.out.println(userService.findAllUsers().toString());
		System.out.println(userService.findByName("firstName2"));
		System.out.println(userService.containsLetters("f"));
	}

}
