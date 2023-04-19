package com.ashwani.restwebservicedocker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashwani.restwebservicedocker.dao.UserDataJpaRepositoryImpl;
import com.ashwani.restwebservicedocker.entity.User;

@Component
public class UserCommandLineRunner implements CommandLineRunner{

	@Autowired
	private UserDataJpaRepositoryImpl userDaoService;
	private final static Logger LOGGER = LoggerFactory.getLogger(UserCommandLineRunner.class);
	
	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("####################################################################################################");
		LOGGER.info("run method -  User is initilized into DB   IN");
		User user = new User();
		user.setId(1);
		user.setName("Ashwani Rawat");
		userDaoService.addUser(user);
		
		user=null;
		user = new User();
		user.setId(2);
		user.setName("Mahesh Kumar");
		userDaoService.addUser(user);
		
		user=null;
		user = new User();
		user.setId(3);
		user.setName("Vikas Dube");
		userDaoService.addUser(user);
		
		user=null;
		user = new User();
		user.setId(4);
		user.setName("Atik Ahamad");
		userDaoService.addUser(user);
		
		user=null;
		user = new User();
		user.setId(5);
		user.setName("Yogi Aditya Nath");
		userDaoService.addUser(user);
		
		user=null;
		user = new User();
		user.setId(6);
		user.setName("Narendra Modi");
		userDaoService.addUser(user);
		
		user=null;
		user = new User();
		user.setId(7);
		user.setName("Madhuri Dixit");
		userDaoService.addUser(user);
		
		user=null;
		user = new User();
		user.setId(8);
		user.setName("Kangana Ranaut");
		userDaoService.addUser(user);
		
		user=null;
		user = new User();
		user.setId(9);
		user.setName("Amitabh Bacchan");
		userDaoService.addUser(user);
		
		LOGGER.info("run method -  User is initilized into DB   OUT");
		LOGGER.info("####################################################################################################");
	}

}
