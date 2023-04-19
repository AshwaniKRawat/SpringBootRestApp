package com.ashwani.restwebservicedocker.controller;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashwani.restwebservicedocker.dao.UserDataJpaRepositoryImpl;
import com.ashwani.restwebservicedocker.entity.User;

@RestController
public class UserRestController {
	private final static Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
	@Autowired
	private UserDataJpaRepositoryImpl userDaoService;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user)
	{
		LOGGER.info("addUser() IN \n  User="+user);
		userDaoService.addUser(user);
		LOGGER.info("addUser() OUT \n ");
			return getUserById(user.getId());
	}
	
	@GetMapping("/getUsers/{id}")
	public String getUserById(@PathVariable int id)
	{
		LOGGER.info("getUserById() IN \n  id="+id);
		List<User> usersList = userDaoService.getAllUsers();
		StringBuffer sb=new StringBuffer();
		sb.append("<html>\r\n\r\n"
				+"<head>\r\n\r\n"
				+"<meta charset=\"ISO-8859-1\">\r\n\r\n"
				+"<title>Spring web application</title>\r\n\r\n"
				+"</head>\r\n\r\n"
				+"<body>\r\n\r\n"
				+"	<table border=1 style=\"height: 100%; width: 100%; background-color: black; color: white\">\r\n\r\n"
				+"		<tr style=\"height: 10%\">\r\n\r\n"
				+"			<td></td>\r\n\r\n"
				+"			<td><center>\r\n\r\n"
				+"					<h1>Hello Docker - Get Users By ID</h1>\r\n\r\n"
				+"					<br><p><h3>Hello Maven + Spring MVC + Jenkins + Docker Example</h3></p><br>\r\n\r\n"
				+"				</center></td>\r\n\r\n"
				+"			<td></td>\r\n\r\n"
				+"		</tr>\r\n");
		
		Iterator<User>iterator=usersList.iterator();
		while(iterator.hasNext()) {
			User user = (User)iterator.next();
			sb.append("<tr  style=height: 80%>");
			if(user.getId()==id)
			{
				sb.append("<td><center>"+user.getId()+"</center></td>\r\n");
				sb.append("<td><center>"+user.getName()+"</center></td>\r\n");
				sb.append("<td><center>Date</center></td>\r\n");
				sb.append("<tr>\r\n");
			}
		}
		sb.append( "		<tr  style=\"height: 10%\">\r\n"
		 		+ "			<td></td>\r\n"
		 		+ "			<td><center>\r\n"
		 		+ "					@Ashwani 8 April 2023\r\n"
		 		+ "				</center></td>\r\n"
		 		+ "			<td></td>\r\n"
		 		+ "		</tr>\r\n"
		 		+ "	</table>\r\n"
		 		+ "</body>\r\n"
		 		+ "</html>");
		LOGGER.info("getUserById() OUT \n  "+sb);
		return sb.toString();
	}
	
	@GetMapping("/getAllUsers")
	String getAllUsers()
	{
		LOGGER.info("getAllUsers() IN \n  ");
		List<User> usersList = userDaoService.getAllUsers();
		StringBuffer sb=new StringBuffer();
		sb.append("<html>\r\n\r\n"
				+"<head>\r\n\r\n"
				+"<meta charset=\"ISO-8859-1\">\r\n\r\n"
				+"<title>Spring web application</title>\r\n\r\n"
				+"</head>\r\n\r\n"
				+"<body>\r\n\r\n"
				+"	<table border=1 style=\"height: 100%; width: 100%; background-color: black; color: white\">\r\n\r\n"
				+"		<tr style=\"height: 10%\">\r\n\r\n"
				+"			<td></td>\r\n\r\n"
				+"			<td><center>\r\n\r\n"
				+"					<h1>Hello Docker - Get All Users</h1>\r\n\r\n"
				+"					<br><p><h3>Hello Maven + Spring MVC + Jenkins + Docker Example</h3></p><br>\r\n\r\n"
				+"				</center></td>\r\n\r\n"
				+"			<td></td>\r\n\r\n"
				+"		</tr>\r\n");
		
		Iterator<User>iterator=usersList.iterator();
		while(iterator.hasNext()) {
			User user = (User)iterator.next();
			sb.append("<tr  style=height: 80%>");
			sb.append("<td><center>"+user.getId()+"</center></td>\r\n");
			sb.append("<td><center>"+user.getName()+"</center></td>\r\n");
			sb.append("<td><center>Date</center></td>\r\n");
			sb.append("<tr>\r\n");
		}
		sb.append( "		<tr  style=\"height: 10%\">\r\n"
		 		+ "			<td></td>\r\n"
		 		+ "			<td><center>\r\n"
		 		+ "					@Ashwani 8 April 2023\r\n"
		 		+ "				</center></td>\r\n"
		 		+ "			<td></td>\r\n"
		 		+ "		</tr>\r\n"
		 		+ "	</table>\r\n"
		 		+ "</body>\r\n"
		 		+ "</html>");
		LOGGER.info("getAllUsers() OUT \n  "+sb);
		return sb.toString();
	}
	
	@GetMapping("/")
	public String apiName()
	{
		return "/getAllUsers,/getUsers/{id},addUser,/getUsers/{id},/addUser     ";
	}
}
