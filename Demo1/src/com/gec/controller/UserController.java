package com.gec.controller;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {//两种请求参数的接受方式
	@RequestMapping("/userLogin")
public String login(String username,
		String userpassword) {
		
		if(username.equals("admin")&&userpassword.equals("123")) {
			return "success";
		}else {
			return "failed";
		}
		
	}

	@RequestMapping("/userLogin1")
public String login1(User user) {//运用一个实体类 定义一个同名的成员变量名称
		
		if(user.getUsername().equals("admin")&&user.getPassword().equals("123")) {
			return "success";
		}else {
			return "failed";
		}
		
	}
}
