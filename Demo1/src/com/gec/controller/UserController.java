package com.gec.controller;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {//������������Ľ��ܷ�ʽ
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
public String login1(User user) {//����һ��ʵ���� ����һ��ͬ���ĳ�Ա��������
		
		if(user.getUsername().equals("admin")&&user.getPassword().equals("123")) {
			return "success";
		}else {
			return "failed";
		}
		
	}
}
