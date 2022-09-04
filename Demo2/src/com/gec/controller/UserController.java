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
UserService userService;//利用接口进行创建 实现多态
	@RequestMapping("/userLogin")
	public String userLogin(User user) {//由于userService方法参数为user对象 所以我们利用user对象
		List<User> userList = userService.selectUser(user);
		//list只能拿到第0个元素（用户名和密码只有一条数据 1702） 只存在于list集合中的第0个元素，想要拿到正确的用户信息
		//生成方法返回值和返回的快捷键ctrl+2松下 再按L
		//判断用户是否登录成功依据是什么？
		//如果说用户乱输， 登录上述列表 肯定为空 user1肯定为空
		//如果登录成功 是有数据的 即返回的list集合不为空
		//通过判断userlist是否为空 或 user1是否为空
		if(userList.isEmpty()){
			//登录成功
			User user1=userList.get(0);
			return "success";
		}
		return "failed";
	}
}
