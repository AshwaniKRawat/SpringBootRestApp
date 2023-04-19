package com.ashwani.restwebservicedocker.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ashwani.restwebservicedocker.entity.User;

@Component
public class UserDataJpaRepositoryImpl {
	private static List<User> users = new ArrayList<>();
	private final static Logger LOGGER = LoggerFactory.getLogger(UserDataJpaRepositoryImpl.class);

	public List<User> getAllUsers() {
		LOGGER.info("getAllUsers() IN");
		
		 LOGGER.info("getAllUsers() OUT");
		return users;
	}

	public void addUser(User user) {
		LOGGER.info("addUser() IN");
		  users.add(user);
		 LOGGER.info("addUser() OUT");
	}

	

}