package com.gec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gec.pojo.User;
import com.gec.service.UserService;

@Controller
public class UserController {
@Autowired
UserService userService;
	@RequestMapping("/userLogin")
	public String userLogin(User user) {
		List<User>userlist=userService.selectUser(user);
		
		if(!userlist.isEmpty()) {
			User user2=userlist.get(0);
			return "success";
		}
		return "failed";}
}
